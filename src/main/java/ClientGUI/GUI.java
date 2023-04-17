package ClientGUI;




import com.proto.LogiHubService.FailureRequest;
import com.proto.LogiHubService.FailureResponse;
import com.proto.LogiHubService.LogiHubServiceGrpc;
import com.proto.LogiHubService.ReturnRequest;
import com.proto.LogiHubService.ReturnResponse;
import com.proto.LogiHubService.ServiceDiscovery;
import com.proto.LogiHubService.StatusRequest;
import com.proto.LogiHubService.StatusResponse;
import com.proto.StockRoomService.OrderRequestt;
import com.proto.StockRoomService.ReadyResponse;
import com.proto.StockRoomService.StockRoomServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GUI implements ActionListener {

    private JTextArea textResponse;
    private JTextArea textResponse2;
    private JTextArea textResponse3;
    private JFrame frame;

    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.build();

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
    
    
    panel1.add(getService1JPanel());
    panel1.add(getService2JPanel());
    panel1.add(getService3JPanel());
    
    
    //////////////////////////////////////////////////////////////////////////////////
    
// Set the panel to add buttons
    JPanel panel2 = new JPanel();
    // Set the BoxLayout to be X_AXIS: from left to right
    BoxLayout boxlayout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
    panel2.setLayout(boxlayout2);
    // Set border for the panel
    panel2.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
    //create JTabbedPane and add tabs
    
    
    panel2.add(getService4JPanel());
    panel2.add(getService5JPanel());
    panel2.add(getService6JPanel());
    
    
    

    
    ////////////////////////////////////////////////////////////////////////////////
    
    JPanel panel3 = new JPanel();
    // Set the BoxLayout to be X_AXIS: from left to right
    BoxLayout boxlayout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
    panel3.setLayout(boxlayout3);
    // Set border for the panel
    panel3.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
    //create JTabbedPane and add tabs
    
    
    panel3.add(getService7JPanel());
    panel3.add(getService8JPanel());
    panel3.add(getService9JPanel());
    
    

// Set size for the frame
    frame.setSize(300, 300);

    // Add text area with scrollpane
    textResponse = new JTextArea(10, 40);
    textResponse.setLineWrap(true);
    textResponse.setWrapStyleWord(true);
    JScrollPane scrollPane = new JScrollPane(textResponse);
    panel1.add(scrollPane);
    
    textResponse2 = new JTextArea(10, 40);
    textResponse2.setLineWrap(true);
    textResponse2.setWrapStyleWord(true);
    JScrollPane scrollPane2 = new JScrollPane(textResponse2);
    panel2.add(scrollPane2);
    
    textResponse3 = new JTextArea(10, 40);
    textResponse3.setLineWrap(true);
    textResponse3.setWrapStyleWord(true);
    JScrollPane scrollPane3 = new JScrollPane(textResponse3);
    panel3.add(scrollPane3);
    
    tabbedPane.addTab("SalesService", panel3);
    tabbedPane.addTab("StockRoom", panel2);
    tabbedPane.addTab("LogiHub", panel1);
    
    

    // Set the window to be visible as the default to be false
    frame.add(tabbedPane);
    frame.pack();
    frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        if (label.equals("Delivery Status")) {
            System.out.println("service LogHub to be invoked ...");
            ServiceInfo serviceInfo;
            String service_type = "_stockcontrol._tcp.local.";

            //Now retrieve the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.
                    forAddress(host, port)
                    .usePlaintext()
                    .build();
            LogiHubServiceGrpc.LogiHubServiceBlockingStub logiHubClient = LogiHubServiceGrpc.newBlockingStub(channel);

            // Create the request message
            StatusRequest request = StatusRequest.newBuilder()
                    .setOrderid("123")
                    .setClientname("Pamela Quintanilha")
                    .setMydelivery("Your order has already been chipped")
                    .build();

            // Call the RPC method and get the response
            StatusResponse response = logiHubClient.deliveryStatus(request);

            // print the answer
            System.out.println("Response received from server:\n" + response.getMystatus());

            String responseText = "Response received from server:\n" + response.getMystatus();
            textResponse.append(responseText);

            // Update the JTextArea with the response
            // End the channel
            channel.shutdown();

        }else if(label.equals("Failure Request")){
            System.out.println("service LogHub to be invoked ...");
            ServiceInfo serviceInfo;
            String service_type = "_stockcontrol._tcp.local.";

            //Now retrieve the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.
                    forAddress(host, port)
                    .usePlaintext()
                    .build();
            LogiHubServiceGrpc.LogiHubServiceBlockingStub logiHubClient = LogiHubServiceGrpc.newBlockingStub(channel);

            FailureRequest failureRequest = FailureRequest.newBuilder()
                    .setOrderid("1234")
                    .setItemname("Losartan")
                    .setReason("Product broken in shipping.")
                    .build();
        
            FailureResponse failureResponse = logiHubClient.failureOrder(failureRequest);
            String responseText = "Identified order Failure in transport -  \n\n" + failureResponse.getConfirmation();
            textResponse.append(responseText);
            channel.shutdown();
            
        }else if(label.equals("Return Request")){
            System.out.println("service LogHub to be invoked ...");
            ServiceInfo serviceInfo;
            String service_type = "_stockcontrol._tcp.local.";

            //Now retrieve the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";

            ManagedChannel channel = ManagedChannelBuilder.
                    forAddress(host, port)
                    .usePlaintext()
                    .build();
            LogiHubServiceGrpc.LogiHubServiceBlockingStub logiHubClient = LogiHubServiceGrpc.newBlockingStub(channel);
            
            ReturnRequest returnRequest = ReturnRequest.newBuilder()
                    .setOrderid("5678")
                    .setClientname("Oseias Viana")
                    .setReason("The product does not match the description")
                    .build();
            ReturnResponse returnResponse = logiHubClient.returnOrder(returnRequest);
            String responseText = " Return request - \n" + returnResponse.getConfirmation();
            textResponse.append(responseText);
            channel.shutdown();
            
        }else if(label.equals("Ready Order")){
            System.out.println("service StockRoom to be invoked ...");
            ServiceInfo serviceInfo;
            String service_type = "_delivery._tcp.local.";
            
            //Now retrieve the service info - all we are supplying is the service type
            serviceInfo = ServiceDiscovery.run(service_type);
            //Use the serviceInfo to retrieve the port
            int port = serviceInfo.getPort();
            String host = "localhost";
            
            ManagedChannel channel = ManagedChannelBuilder.
                    forAddress(host, port)
                    .usePlaintext()
                    .build();
            StockRoomServiceGrpc.StockRoomServiceBlockingStub stockRoomClient = StockRoomServiceGrpc.newBlockingStub(channel);

            OrderRequestt request = OrderRequestt.newBuilder().setOrderid("")
                    .setOrderid("80098")
                    .setClientname("Pedro Luiz")
                    .build();
            ReadyResponse repply = stockRoomClient.readyOrder(request);
            String responseText = "Checking if order is ready to delivery..." + repply.getOrderStatus();
            textResponse.append(responseText);
            channel.shutdown();
            
        }
        else if(label.equals("Return Request")){
        
        }
        else if(label.equals("Return Request")){
        
        }
        else if(label.equals("Return Request")){
        
        }
        else if(label.equals("Return Request")){
        
        }
        else if(label.equals("Return Request")){
        
        }
        
    }

    //Calling the three services
    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Delivery Status");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Failure Request");
        button.addActionListener(this);
        panel.add(button, BorderLayout.NORTH);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Return Request");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Ready Order");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService5JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Send Order");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService6JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Check Payment");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService7JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Send Order");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService8JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Check Payment");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
    
    private JPanel getService9JPanel() {

        JPanel panel = new JPanel();
        JButton button = new JButton("Feedback");
        button.addActionListener(this);
        panel.add(button);
        return panel;

    }
}
