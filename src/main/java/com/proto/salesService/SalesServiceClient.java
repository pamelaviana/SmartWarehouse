package com.proto.salesService;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SalesServiceClient {

	// stubs: a stub blocking (blocker) and another async stub (asynchronous) that
	// are used to make remote procedure calls to the server.
	private static SalesServiceGrpc.SalesServiceBlockingStub blockingStub;
	// Asynch stub
	private static SalesServiceGrpc.SalesServiceStub asyncStub;

	// The main method will have the logic for client.
	public static void main(String[] args) throws Exception {

		// Creates a communication channel for the server at address "localhost" and
		// port 50053.
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

		// stubs -- generate from proto
		blockingStub = SalesServiceGrpc.newBlockingStub(channel);
		asyncStub = SalesServiceGrpc.newStub(channel);

		// method call
		SendOrder();

		checkPayment();

		feedback();

		// Closing the channel once message has been passed.
		channel.shutdown();
	}

	// Client stream
	public static void SendOrder() {
		// Declares a StreamObserver instance that receives the response from the server
		// when the client sends a message.
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

		// Here, we are calling the Remote sendOrder method. Using onNext, client sends
		// a stream of messages.
		StreamObserver<OrderRequest> requestObserver = asyncStub.sendOrder(responseObserver);

		try {
			// Sends a message of type OrderRequest to the server.
			requestObserver.onNext(
					OrderRequest.newBuilder().setClientid("8004").setOrderid("8791").setPhonenumber("87 4394537")
							.setPurchaseprice(12.96).setProductname("Lorsartan").setQuantity(5).build());

			requestObserver.onNext(
					OrderRequest.newBuilder().setClientid("8005").setOrderid("8792").setPhonenumber("87 4364487")
							.setPurchaseprice(11.85).setProductname("Zinco").setQuantity(2).build());

			requestObserver.onNext(
					OrderRequest.newBuilder().setClientid("8006").setOrderid("8793").setPhonenumber("83 4368976")
							.setPurchaseprice(15.55).setProductname("Vitamin C").setQuantity(1).build());

			requestObserver.onNext(
					OrderRequest.newBuilder().setClientid("8007").setOrderid("8794").setPhonenumber("82 2396535")
							.setPurchaseprice(1.99).setProductname("Magnesium").setQuantity(1).build());

			System.out.println("Sending purchases...");

			// Informs the server that the client has finished sending messages.
			requestObserver.onCompleted();

			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}

	private static void checkPayment() {
		// Creates a PaymentRequest to verify the payment of the request and receives
		// the response from the server.
		PaymentRequest paymentrequest = PaymentRequest.newBuilder().setOrderid("8791").setClientname("Alice")
				.setPaymenttotal(12.96).build();

		PaymentResponse paymentresponse = blockingStub.checkPayment(paymentrequest);
		System.out.println(" \n\nSending order for payment to be analyzed\n" + paymentresponse.getPaymentstatus());

	}

	public static void feedback() {
		// Declares a StreamObserver instance that receives the response from the server
		// when the client sends a comment.
		StreamObserver<FeedbackResponse> responseObserver = new StreamObserver<FeedbackResponse>() {

			@Override
			public void onNext(FeedbackResponse value) {

				System.out.println("Response from server: " + value.getMessage());
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

		// Send a message to the server.
		StreamObserver<FeedbackRequest> requestObserver = asyncStub.feedback(responseObserver);

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
				latch.await(3L, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (RuntimeException e) {
			System.out.println(" Handling Exceptions");
			e.printStackTrace();
		}
	}

}
