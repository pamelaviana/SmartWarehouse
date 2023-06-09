package com.proto.LogiHubService;

import java.util.concurrent.TimeUnit;

import com.proto.LogiHubService.LogiHubServiceGrpc.LogiHubServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class LogiHubClient {
	public static void main(String[] args) {
		String host = "localhost";

		// To do the link
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, 50054).usePlaintext().build();

		LogiHubServiceBlockingStub blockingstub = LogiHubServiceGrpc.newBlockingStub(channel);

		System.out.println(" LogiHub starting... \"\n");

		String status = "Your order has already been chipped";

		try {
			// Calling the DeliveryStatus method
			deliveryStatus(status, blockingstub);

			// Calling the FailureOrder method
			failureRequest(blockingstub);

			// Calling the ReturnOrder method
			returnRequest(blockingstub);

		} catch (StatusRuntimeException e) {
			System.out.println("Error: " + e.getStatus());
		} finally {
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

	// Unary RPC
	private static void deliveryStatus(String status, LogiHubServiceBlockingStub blockingstub) {
		StatusRequest request = StatusRequest.newBuilder().setOrderid("1345").setClientname("Pamela Quintanilha")
				.setMydelivery(status).build();
		StatusResponse reply = blockingstub.deliveryStatus(request);
		System.out.println("\n\nReceiving status from the server - \n\n" + reply.getMystatus());
	}

	// Unary RPC
	private static void failureRequest(LogiHubServiceBlockingStub blockingstub) {
		FailureRequest failureRequest = FailureRequest.newBuilder().setOrderid("1234").setItemname("Losartan")
				.setReason("Product broken in shipping.").build();
		FailureResponse failureResponse = blockingstub.failureOrder(failureRequest);
		System.out.println("\n\nReceiving message from the server -  \n\n" + failureResponse.getConfirmation());

	}

	// Unary RPC
	private static void returnRequest(LogiHubServiceBlockingStub blockingstub) {
		ReturnRequest returnRequest = ReturnRequest.newBuilder().setOrderid("5678").setClientname("Oseias Viana")
				.setReason("The product does not match the description").build();
		ReturnResponse returnResponse = blockingstub.returnOrder(returnRequest);
		System.out.println(" \n\nReceiving message by the server - \n" + returnResponse.getConfirmation());
		System.out.println(" \nLogiHub is completed... \n");
	}

}
