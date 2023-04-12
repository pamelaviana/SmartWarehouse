// Name of the package where all the generated files are present.
package com.proto.salesService;


import java.io.FileInputStream;
//required java packages for the program. Depends on your logic.
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
//import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
import com.proto.salesService.SalesServiceGrpc.SalesServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
//import io.grpc.stub.StreamObserver;

//just test


public class SalesServiceServer extends SalesServiceImplBase {
	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		//private static final Logger logger = Logger.getLogger(SalesServiceServer.class.getName());
	
	
		// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
				// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
			 public static void main(String[] args) {
				 
				 
				// The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
				 SalesServiceServer salesservice = new SalesServiceServer();
				 
				 //property
				 Properties prop = salesservice .getProperties();
				 
				 salesservice.registerService2(prop);
				 
				 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
				    //int port = 50053;
				    int port = Integer.valueOf( prop.getProperty("service_port") );// #.50054;
				    
				    
				 try {
				    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
				        .addService(salesservice ) // Service is defined in line 31
				        .build() // Build the server
				        .start(); // Start the server and keep it running for clients to contact.
				 
				    // Giving a logging information on the server console that server has started
				    //logger.info("Server started, listening on " + port);
				    		    
				    ////Giving a logging information on the server console that server has started
				    System.out.println("Sales server started, listening on " + port);
				    // Server will be running until externally terminated.
				    server.awaitTermination();
				 } catch (IOException e) {
				 //TODO Auto-generated catch block
				 e.printStackTrace();
				 } catch (InterruptedException e) {
				 //TODO Auto-generated catch block
				 e.printStackTrace();
				 }
				 }
			 
			 
			 private Properties getProperties() {
				 Properties prop = null; 
				 try (InputStream input = new FileInputStream("src/main/resources/SalesService.properties")) {
					 prop = new Properties();

					//load a properties file
					prop.load(input);

					//get the property value and print it out
					System.out.println("LogiHub Service properties ...");
					System.out.println("\t service_type: " + prop.getProperty("service_type"));
					System.out.println("\t service_name: " +prop.getProperty("service_name"));
					System.out.println("\t service_description: " +prop.getProperty("service_description"));
					System.out.println("\t service_port: " +prop.getProperty("service_port"));
				
				 } catch (IOException ex) {
					 ex.printStackTrace();
					 }
					 return prop;
					 }
			 private void registerService2(Properties prop) {
				 
					try {
						//Create a JmDNS instance
						JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

						String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
						String service_name = prop.getProperty("service_name") ;// "salesservice";
						
						//int service_port = 1234;
						int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;
						String service_description_properties = prop.getProperty("service_description") ;//"path=index.html";

						//Register a service
						ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
						jmdns.registerService(serviceInfo);

						System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

						//Wait a bit
						Thread.sleep(1000);

						//Unregister all services
						//jmdns.unregisterAllServices();
						} catch (IOException e) {
						System.out.println(e.getMessage());
						} catch (InterruptedException e) {
						//TODO Auto-generated catch block
						e.printStackTrace();
						}
						}


				 
			 


			@Override
			public StreamObserver<OrderRequest> sendOrder(StreamObserver<OrderResponse> responseObserver) {

				// Retrieve the value from the stream of requests of the client. 
				return new StreamObserver<OrderRequest>() {
			
					

					String receipt = " ";
					@Override
					public void onNext(OrderRequest orderRequest) {
						receipt += "\n The followinh Order has been received:\n"+" Client ID: "+orderRequest.getClientid()
			            +" Order ID: " + orderRequest.getOrderid()
						+" Phone Number: " + orderRequest.getPhonenumber()
						+" Purchase Price: " + orderRequest.getPurchaseprice()
						+" Product Name: " + orderRequest.getProductname()
						+" Quantity: " + orderRequest.getQuantity()+"\n We are checking the payment.";
						
						System.out.println("===============================================================");
					/*	
						// Keep on adding all the message(receipt) values to compute the total receipts of strings sent by the client in the stream 
						receipt += orderRequest.getClientid()
						        +" Order ID: " + orderRequest.getOrderid()
								+" Phone Number: " + orderRequest.getPhonenumber()
								+" Purchase Price: " + orderRequest.getPurchaseprice()
								+" Product Name: " + orderRequest.getProductname()
								+" Quantity: " + orderRequest.getQuantity();*/
				}
				
					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}
					// Once the complete stream is received this logic will be executed.
					@Override
					public void onCompleted() {
						// Preparing and sending the reply for the client. Here, response is build and with the value (length) computed by above logic.
						 // Here, response is sent once the client is done with sending the stream.
						  OrderResponse res = OrderResponse.newBuilder().setMymessage(receipt).build();
				          responseObserver.onNext(res);
				          //responseObserver.onCompleted();
							//responseObserver.onCompleted();
							
							//System.out.println("===============================================================");
					}
				};
			}
		


			@Override
			public void checkPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
			
			       //Logical code
			        	// TODO Auto-generated method stub 
				String orderId =request.getOrderid();
				String clientName = request.getClientname();
				double paymentTotal = request.getPaymenttotal();
				   
			
				   String mypayment = "\nThe follow payment: "+"\nOrder ID: "+orderId+"\nClient name: "+clientName+"\nPayment total: "+paymentTotal+" \nhas been authorized!!";
				  

		 // Build a response message
			    

					    PaymentResponse res = PaymentResponse.newBuilder()
					    .setPaymentstatus(mypayment)
					    .build();
					    
					     // Send the response back to the client
					    responseObserver.onNext(res);
					    responseObserver.onCompleted();
					}
				
				


			


	
	//RPC Bidirecional Streaming.

	@Override
	public StreamObserver<FeedbackRequest> feedback(StreamObserver<FeedbackResponse> responseObserver) {
		// TODO Auto-generated method stub
		    //return new StreamObserver<FeedbackRequest>() {
		 StreamObserver<FeedbackRequest> requestObserver = new
				 StreamObserver<FeedbackRequest>  () {
		        @Override
		        public void onNext(FeedbackRequest value) {
		        
		       
		        	String response = "Thank you for your feedback. We appreciate it! => ( "+ value.getFeedbackClient()+" )";
		        	
		        	   // Preparing and sending the reply for the client. Here, response is build and with the value (input1.toString()) computed by above logic.
			          FeedbackResponse feedbackresponse = FeedbackResponse.newBuilder().setMessage(response).build();
					
			
				     
		              responseObserver.onNext(feedbackresponse);
		             
		        }
				
					

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stubal
				
			}

			@Override
			public void onCompleted() {
				 responseObserver.onCompleted();
				
			}
			
		};
		 return requestObserver;
		 
	}
	
}
	



		    





			 


  
    
 