package com.proto.salesService;

import java.util.Arrays;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


//import com.proto.salesService.SalesServiceGrpc.SalesServiceBlockingStub;


//import io.grpc.StatusRuntimeException;

public class SalesServiceClient {
	
    // First we create a logger to show client side logs in the console. logger instance will be used to log different events at the client console.
    // This is optional. Could be used if needed.
    //private static  Logger logger = Logger.getLogger(SalesServiceClient.class.getName());

    // Creating stubs for establishing the connection with server.
    // Blocking stub
    
    private static SalesServiceGrpc.SalesServiceBlockingStub blockingStub;
    // Asynch stub
    private static SalesServiceGrpc.SalesServiceStub asyncStub;

    // The main method will have the logic for client.
    public static void main(String[] args) throws Exception {
				
    // First a channel is being created to the server from client. Here, we provide the server name (localhost) and port (50053).
    // As it is a local demo of GRPC, we can have non-secured channel (usePlaintext).
		
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

    //stubs -- generate from proto
    blockingStub = SalesServiceGrpc.newBlockingStub(channel);
    asyncStub = SalesServiceGrpc.newStub(channel);


    // clientstreaming method call
    SendOrder();

    checkPayment();
		
    feedback();
		
		
    // Closing the channel once message has been passed.
    channel.shutdown();
		
		
}
			
//Client stream 

    public static void SendOrder() {
        // Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
        StreamObserver<OrderResponse> responseObserver = new StreamObserver<OrderResponse>() {

                @Override
                public void onNext(OrderResponse value) {
                        System.out.println("receiving message response: " + value.getMymessage());
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
                Thread.sleep(new Random().nextInt(1000) + 500);


                 System.out.println("==================================================================\n" );




        } catch (RuntimeException e) {
                e.printStackTrace();
        } catch (InterruptedException e) {			
                e.printStackTrace();
        }


        }
    
    
    private static void checkPayment() {
        PaymentRequest paymentrequest = PaymentRequest.newBuilder()
            .setOrderid("8791")
            .setClientname("Alice")
            .setPaymenttotal(12.96)
            .build();

            PaymentResponse paymentresponse =  blockingStub. checkPayment(paymentrequest);
            System.out.println(" Sending order for payment to be analyzed\n\n" + paymentresponse.getPaymentstatus());
            System.out.println("==================================================================\n" );
    }
			

    public static void feedback() {
        StreamObserver<FeedbackResponse> responseObserver = new StreamObserver<FeedbackResponse>() {

        @Override
        public void onNext(FeedbackResponse value){

                System.out.println("Response from server: " + value.getMessage ());
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
        Arrays.asList("The product quality is excellent!" , "The delivery time was very fast.", "The price was fair and the service was worth it.",
        "beta-adrenergic" ).forEach(
            comments ->{
                System.out.println("Sending: " + comments);
                requestObserver.onNext(FeedbackRequest.newBuilder()
                //set the blood pressure and the treatment
                .setFeedbackClient(comments)
                .build());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("==================================================================\n" );
                }
            }

        );

        requestObserver.onCompleted();

        try {
            latch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }catch(RuntimeException e) {
            System.out.println(" Handling Exceptions");
            e.printStackTrace();
        }
    }
    
    
    
    

 
}
