// Name of the package where all the generated files are present.
package com.proto.salesService;


//required java packages for the program. Depends on your logic.
import java.io.IOException;
import java.util.logging.Logger;

//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
import com.proto.salesService.SalesServiceGrpc.SalesServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
//import io.grpc.stub.StreamObserver;


public class SalesServiceServer extends SalesServiceImplBase {
	// First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
		private static final Logger logger = Logger.getLogger(SalesServiceServer.class.getName());
	
	
		// Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
				// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
			 public static void main(String[] args) throws IOException, InterruptedException {
				 
				 
				// The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
				 SalesServiceServer salesserver = new SalesServiceServer();
				 
				 // This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking)
				    int port = 50053;
				    
				 // Here, we create a server on the port defined in in variable "port" and attach a service "salesserver " (instance of the class) defined above.
				    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
				        .addService(salesserver ) // Service is defined in line 31
				        .build() // Build the server
				        .start(); // Start the server and keep it running for clients to contact.
				 
				    // Giving a logging information on the server console that server has started
				    logger.info("Server started, listening on " + port);
				    		    
				    // Server will be running until externally terminated.
				    server.awaitTermination();
				 
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
				          responseObserver.onCompleted();
							responseObserver.onCompleted();
							
							System.out.println("===============================================================");
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
	



		    





			 


  
    
 