package com.proto.salesService;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;



import com.proto.salesService.SalesServiceGrpc.SalesServiceBlockingStub;
import com.proto.salesService.SalesServiceGrpc.SalesServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class GUIImplemSales {
	
	private static SalesServiceStub nonblockingstub;
	

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("LoguiHub server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
        //stubs -- generate from proto
        SalesServiceBlockingStub blockingStub = SalesServiceGrpc.newBlockingStub(channel);
        SalesServiceStub asyncStub = SalesServiceGrpc.newStub(channel);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

        JPanel panelText = new JPanel();
        panel.setLayout(new BorderLayout());

		JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension( 450, 480 ) );
        textPane.setEditable(false);

		JButton SendOrderButton = new JButton("Sending order ");
		JButton checkPaymentButton = new JButton("Cheking payment ");
		JButton feedbackButton = new JButton(" Feedback ");

		panel.add(SendOrderButton, BorderLayout.NORTH);
		panel.add(checkPaymentButton, BorderLayout.CENTER);
		panel.add(feedbackButton, BorderLayout.SOUTH);
        panelText.add(textPane, BorderLayout.CENTER);

		frame.getContentPane().add(panel, BorderLayout.WEST);
		frame.getContentPane().add(panelText, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(460,480);
		
		
		/**/
		
	

		SendOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   StreamObserver<OrderResponse> responseObserver = new StreamObserver<OrderResponse>() {

		                @Override
		                public void onNext(OrderResponse value) {
		                	textPane.setText("");
		                	 textPane.setText("receiving message response: " + value.getMymessage());
		                }

		                @Override
		                public void onError(Throwable t) {
		                        // TODO Auto-generated method stub

		                }

		                @Override
		                public void onCompleted() {
		                        System.out.println("completed ");

		                }
				   

		        };

		        // Here, we are calling the Remote sendOrder method. Using onNext, client sends a stream of messages.
		        StreamObserver<OrderRequest> requestObserver = asyncStub.sendOrder(responseObserver);

		        try {

		                requestObserver.onNext(OrderRequest.newBuilder() .setClientid("8004")
		              .setOrderid("8791")
		              .setPhonenumber("87 4394537")
		              .setPurchaseprice(12.96)
		              .setProductname("Lorsartan")
		              .setQuantity(5)
		              .build());


		                requestObserver.onNext(OrderRequest.newBuilder().setClientid("8005")
		              .setOrderid("8792")
		              .setPhonenumber("87 4364487")
		              .setPurchaseprice(11.85)
		              .setProductname("Zinco")
		              .setQuantity(2)
		              .build());


		                requestObserver.onNext(OrderRequest.newBuilder() .setClientid("8006")
		              .setOrderid("8793")
		              .setPhonenumber("83 4368976")
		              .setPurchaseprice(15.55)
		              .setProductname("Vitamin C")
		              .setQuantity(1)
		              .build());


		                requestObserver.onNext(OrderRequest.newBuilder().setClientid("8007")
		              .setOrderid("8794")
		              .setPhonenumber("82 2396535")
		              .setPurchaseprice(1.99)
		              .setProductname("Magnesium")
		              .setQuantity(1)
		              .build());


		            	System.out.println("Sending purchases...");
		                
		              




		    // Mark the end of requests
		                requestObserver.onCompleted();


		                // Sleep for a bit before sending the next one.
		                Thread.sleep(new Random().nextInt(2000) + 500);


		                 System.out.println("==================================================================\n" );




		        } catch (RuntimeException ex) {
		                ex.printStackTrace();
		        } catch (InterruptedException ex) {			
		                ex.printStackTrace();
		        }
            }
        });
		
		
		
			
			checkPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	   PaymentRequest paymentrequest = PaymentRequest.newBuilder()
                	            .setOrderid("8791")
                	            .setClientname("Alice")
                	            .setPaymenttotal(12.96)
                	            .build();

                	   //IrrigationStatusResponse replyIS = blockingStub.setIrrigation(request);
                	   // textPane.setText("Message sent by the server: " + replyIS.getMyirrigationstatusResponse());
                	   PaymentResponse paymentresponse =  blockingStub. checkPayment(paymentrequest);
                    textPane.setText("");
                    textPane.setText(" Sending order for payment to be analyzed\n\n" + paymentresponse.getPaymentstatus());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                    
                
                }
            }
        });
			
		

                feedbackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	StreamObserver<FeedbackResponse> responseObserver = new StreamObserver<FeedbackResponse>() {

                        @Override
                        public void onNext(FeedbackResponse value){
                        	
                        	textPane.setText("");

                        	 textPane.setText("Response from server: " + value.getMessage ());
                        }

                        @Override
                        public void onError(Throwable t) {
                                // TODO Auto-generated method stub

                        }

                        @Override
                        public void onCompleted() {
                                // TODO Auto-generated method stub
                                System.out.println("server completed");
                                
                        }
                        
                    };


                    StreamObserver<FeedbackRequest> requestObserver = asyncStub.feedback(responseObserver);

                     //CountDownLatch is used to make sure that a task waits for other threads before it starts.
                    CountDownLatch latch = new CountDownLatch(1);

                    try {
                        Arrays.asList("The product quality is excellent!" , "The delivery time was very fast.", "The price was fair and the service was worth it." ).forEach(
                            comments ->{
                                System.out.println("Sending: " + comments);
                                requestObserver.onNext(FeedbackRequest.newBuilder()
                               
                                .setFeedbackClient(comments)
                                .build());

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException exx) {
                                    exx.printStackTrace();
                                    System.out.println("==================================================================\n" );
                                }
                            }
                    
                    );

                        requestObserver.onCompleted();

                        try {
                            latch.await(3L, TimeUnit.SECONDS);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }


                        }catch(RuntimeException ex) {
                            System.out.println(" Handling Exceptions");
                            ex.printStackTrace();
                        }
                
                }finally {
                	
                }
			}
			
 });
                
	}}
                
	
	

                
                        
                
			
        
		    
		    
		    
		    
		    
		    

		 
		

          
        			
        		
        	
               
	

		
