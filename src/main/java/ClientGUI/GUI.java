package ClientGUI;


import com.proto.ErrorHandlingInterceptor.ErrorHandlingInterceptor;
import com.proto.LogiHubService.*;
import com.proto.StockRoomService.*;
import com.proto.salesService.OrderRequest;
import com.proto.salesService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class GUI implements ActionListener {

    private static LogiHubServiceGrpc.LogiHubServiceBlockingStub logiHubClient;
    private static StockRoomServiceGrpc.StockRoomServiceBlockingStub stockRoomClient;
    private static StockRoomServiceGrpc.StockRoomServiceStub asyncStockRoomClient;
    private static SalesServiceGrpc.SalesServiceBlockingStub salesClient;
    private static SalesServiceGrpc.SalesServiceStub asyncSalesClient;
    private JTextArea textResponse;
    private JTextArea textResponse2;
    private JTextArea textResponse3;

    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.build();

        String host = "localhost";

        int port_logi = 50054;
        int port_stock = 50052;
        int port_sales = 50053;

        // Connection to LogiHub Server
        ManagedChannel channelLogi = ManagedChannelBuilder.forAddress(host, port_logi).intercept(new ErrorHandlingInterceptor()).usePlaintext().build();
        logiHubClient = LogiHubServiceGrpc.newBlockingStub(channelLogi);

        // Connection to StockRoom Server
        ManagedChannel channelStock = ManagedChannelBuilder.forAddress(host, port_stock).intercept(new ErrorHandlingInterceptor()).usePlaintext().build();
        stockRoomClient = StockRoomServiceGrpc.newBlockingStub(channelStock);
        asyncStockRoomClient = StockRoomServiceGrpc.newStub(channelStock);

        // Connection to Sales Server
        ManagedChannel channelSales = ManagedChannelBuilder.forAddress(host, port_sales).intercept(new ErrorHandlingInterceptor()).usePlaintext().build();
        salesClient = SalesServiceGrpc.newBlockingStub(channelSales);
        asyncSalesClient = SalesServiceGrpc.newStub(channelSales);
    }

    private static void DeliveryStatus(JTextArea textResponse) {
        try {
            // Set empty to text response
            textResponse.setText("");

            // Create the request message
            StatusRequest request = StatusRequest.newBuilder()
                    .setOrderid("123")
                    .setClientname("Pamela Quintanilha")
                    .setMydelivery("Your order has already been chipped")
                    .build();

            // Call the RPC method and get the response
            StatusResponse response = logiHubClient.deliveryStatus(request);

            String responseText = "Response received from server:\n" + response.getMystatus();
            textResponse.append(responseText);
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static void FailureRequest(JTextArea textResponse) {
        try {
            // Set empty to text response
            textResponse.setText("");

            FailureRequest failureRequest = FailureRequest.newBuilder()
                    .setOrderid("1234")
                    .setItemname("Losartan")
                    .setReason("Product broken in shipping.")
                    .build();

            FailureResponse failureResponse = logiHubClient.failureOrder(failureRequest);
            String responseText = "Identified order Failure in transport -  \n" + failureResponse.getConfirmation();
            textResponse.append(responseText);
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static void ReturnRequest(JTextArea textResponse) {
        try {
            // Set empty to text response
            textResponse.setText("");

            ReturnRequest returnRequest = ReturnRequest.newBuilder()
                    .setOrderid("5678")
                    .setClientname("Oseias Viana")
                    .setReason("The product does not match the description")
                    .build();

            ReturnResponse returnResponse = logiHubClient.returnOrder(returnRequest);
            String responseText = " Return request - \n" + returnResponse.getConfirmation();
            textResponse.append(responseText);
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Stock Room Service
    private static void ReadyOrder(JTextArea textResponse) {
        try {
            textResponse.setText("");

            OrderRequestt request = OrderRequestt.newBuilder().setOrderid("")
                    .setOrderid("80098")
                    .setClientname("Pedro Luiz")
                    .build();

            ReadyResponse repply = stockRoomClient.readyOrder(request);

            String responseText = "Checking if order is ready to delivery..." + repply.getOrderStatus();
            textResponse.append(responseText);
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void StockSupply(JTextArea textResponse) {
        try {
            textResponse.setText("");

            int num1 = 220;// The current qtity of one item
            int num2 = 30;// Simulates the quantity of an item being supplied.

            StockSupplyRequest req = StockSupplyRequest.newBuilder().setCurrentQty(num1).setInputQty(num2).build();

            // Response from the server is then stored in the response variable(req), which
            // is of type StockSupplyResponse.
            StockSupplyResponse response = stockRoomClient.stockSupply(req);

            // prints out the result of the stockSupply() operation. It concatenates a
            // string that includes the result and mysupply fields of the response object.
            textResponse.append("Cheking quantity of Losartana into stock => "
                    + response.getResult() + " units  \n" + response.getMysupply());
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void StockAlert(JTextArea textResponse) {
        textResponse.setText("");
        try {
            AlertRequest request = AlertRequest.newBuilder().setItemname("Losartana").setMinStockLevel(5).build();

            StreamObserver<AlertResponse> responseObserver = new StreamObserver<AlertResponse>() {

                int count = 0;

                // @Override
                public void onNext(AlertResponse value) {
                    textResponse.append("Received alert message: " + value.getMessage() + "\n");
                    count += 1;
                }

                @Override
                public void onError(Throwable t) {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }

                @Override
                public void onCompleted() {
                    textResponse.append("Streaming completed " + count + " message of alert\n");
                    textResponse.append("server completed\n");

                }
            };
            asyncStockRoomClient.stockAlert(request, responseObserver);

            Thread.sleep(100);
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void SendOrder(JTextArea textResponse) {
        try {
            textResponse.setText("");

            // Declares a StreamObserver instance that receives the response from the server
            // when the client sends a message.
            StreamObserver<OrderResponse> responseObserver = new StreamObserver<OrderResponse>() {

                @Override
                public void onNext(OrderResponse value) {
                    textResponse.append("receiving message response: " + value.getMymessage() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }

                @Override
                public void onCompleted() {
                    textResponse.append("completed");
                }

            };

            // Here, we are calling the Remote sendOrder method. Using onNext, client sends
            // a stream of messages.
            StreamObserver<com.proto.salesService.OrderRequest> requestObserver = asyncSalesClient.sendOrder(responseObserver);

            try {
                // Sends a message of type OrderRequest to the server.
                requestObserver.onNext(
                        com.proto.salesService.OrderRequest.newBuilder().setClientid("8004").setOrderid("8791").setPhonenumber("87 4394537")
                                .setPurchaseprice(12.96).setProductname("Lorsartan").setQuantity(5).build());

                requestObserver.onNext(
                        com.proto.salesService.OrderRequest.newBuilder().setClientid("8005").setOrderid("8792").setPhonenumber("87 4364487")
                                .setPurchaseprice(11.85).setProductname("Zinco").setQuantity(2).build());

                requestObserver.onNext(
                        com.proto.salesService.OrderRequest.newBuilder().setClientid("8006").setOrderid("8793").setPhonenumber("83 4368976")
                                .setPurchaseprice(15.55).setProductname("Vitamin C").setQuantity(1).build());

                requestObserver.onNext(
                        OrderRequest.newBuilder().setClientid("8007").setOrderid("8794").setPhonenumber("82 2396535")
                                .setPurchaseprice(1.99).setProductname("Magnesium").setQuantity(1).build());

                textResponse.append("Sending purchases... \n");

                // Informs the server that the client has finished sending messages.
                requestObserver.onCompleted();

                // Sleep for a bit before sending the next one.
                Thread.sleep(new Random().nextInt(1000) + 500);

            } catch (Exception e) {
                // Show alert with error message
                JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void CheckPayment(JTextArea textResponse) {
        try {
            textResponse.setText("");
            PaymentRequest paymentrequest = PaymentRequest.newBuilder().setOrderid("8791").setClientname("Alice")
                    .setPaymenttotal(12.96).build();

            PaymentResponse paymentresponse = salesClient.checkPayment(paymentrequest);
            textResponse.append(" \n\nSending order for payment to be analyzed\n" + paymentresponse.getPaymentstatus());
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void Feedback(JTextArea textResponse) {
        try {
            textResponse.setText("");

            // Declares a StreamObserver instance that receives the response from the server
            // when the client sends a comment.
            StreamObserver<FeedbackResponse> responseObserver = new StreamObserver<FeedbackResponse>() {

                @Override
                public void onNext(FeedbackResponse value) {

                    textResponse.append("Response from server: " + value.getMessage() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }

                @Override
                public void onCompleted() {
                    // TODO Auto-generated method stub
                    textResponse.append("server completed");
                }
            };

            // Send a message to the server.
            StreamObserver<FeedbackRequest> requestObserver = asyncSalesClient.feedback(responseObserver);

            // CountDownLatch is used to make sure that a task waits for other threads
            // before it starts.
            CountDownLatch latch = new CountDownLatch(1);

            try {//list to store all feedback
                Arrays.asList("The product quality is excellent!", "The delivery time was very fast.",
                        "The price was fair and the service was worth it.").forEach(comments -> {
                            System.out.println("\n\nSending feedback: " + comments);
                            requestObserver.onNext(FeedbackRequest.newBuilder()

                                    .setFeedbackClient(comments).build());

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();

                            }
                        }

                );

                requestObserver.onCompleted();// Informs the server that the client has finished sending messages

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                // Show alert with error message
                JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // Show alert with error message
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void build() {
        //create the tittle
        JFrame frame = new JFrame("Smart Warehouse App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel1 = new JPanel();
        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxlayout);
        // Set border for the panel
        panel1.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
        //create JTabbedPane and add tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add text area with scrollpane
        textResponse = new JTextArea(10, 40);
        textResponse.setLineWrap(true);
        textResponse.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textResponse);
        panel1.add(scrollPane);

        panel1.add(getService1JPanel(textResponse));
        panel1.add(getService2JPanel(textResponse));
        panel1.add(getService3JPanel(textResponse));


        //////////////////////////////////////////////////////////////////////////////////

        // Set the panel to add buttons
        JPanel panel2 = new JPanel();
        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        panel2.setLayout(boxlayout2);
        // Set border for the panel
        panel2.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));


        //create JTabbedPane and add tabs
        textResponse2 = new JTextArea(10, 40);
        textResponse2.setLineWrap(true);
        textResponse2.setWrapStyleWord(true);
        JScrollPane scrollPane2 = new JScrollPane(textResponse2);
        panel2.add(scrollPane2);

        panel2.add(getService4JPanel(textResponse2));
        panel2.add(getService5JPanel(textResponse2));
        panel2.add(getService6JPanel(textResponse2));

        ////////////////////////////////////////////////////////////////////////////////

        JPanel panel3 = new JPanel();
        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
        panel3.setLayout(boxlayout3);
        // Set border for the panel
        panel3.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
        //create JTabbedPane and add tabs


        textResponse3 = new JTextArea(10, 40);
        textResponse3.setLineWrap(true);
        textResponse3.setWrapStyleWord(true);
        JScrollPane scrollPane3 = new JScrollPane(textResponse3);
        panel3.add(scrollPane3);

        panel3.add(getService7JPanel(textResponse3));
        panel3.add(getService8JPanel(textResponse3));
        panel3.add(getService9JPanel(textResponse3));


        // Set size for the frame
        frame.setSize(300, 300);


        tabbedPane.addTab("SalesService", panel3);
        tabbedPane.addTab("StockRoom", panel2);
        tabbedPane.addTab("LogiHub", panel1);


        // Set the window to be visible as the default to be false
        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);

    }

    //Calling the three services
    private JPanel getService1JPanel(JTextArea textResponse) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Delivery Status");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeliveryStatus(textResponse);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService2JPanel(JTextArea textResponse) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Failure Request");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FailureRequest(textResponse);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button, BorderLayout.NORTH);

        return panel;

    }

    private JPanel getService3JPanel(JTextArea textResponse) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Return Request");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnRequest(textResponse);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService4JPanel(JTextArea textResponse2) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Ready Order");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadyOrder(textResponse2);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService5JPanel(JTextArea textResponse2) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Stock Supply");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockSupply(textResponse2);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService6JPanel(JTextArea textResponse2) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Stock Alert");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockAlert(textResponse2);
            }
        });

        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService7JPanel(JTextArea textResponse3) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Send Order");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendOrder(textResponse3);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;
    }

    private JPanel getService8JPanel(JTextArea textResponse3) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Check Payment");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckPayment(textResponse3);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;

    }

    private JPanel getService9JPanel(JTextArea textResponse3) {

        JPanel panel = new JPanel();
        JButton button = new JButton("Feedback");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Feedback(textResponse3);
            }
        });
        button.setPreferredSize(new Dimension(150, 30));
        panel.add(button);
        return panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method
    }
}
