package com.proto.StockRoomService;

import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceBlockingStub;
import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
//import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class StockRoomClient {
	private static StockRoomServiceBlockingStub blockingStub;
	private static StockRoomServiceStub asyncStub;

	public static void main(String[] args) {

		 System.out.println(" StockRomm server at starting... \"\n" );

		/*
		 * It creates a new ManagedChannel object to connect to the gRPC server running
		 * on localhost:50052. It initializes two stubs, a blocking stub and an
		 * asynchronous stub, from the StockRoomServiceGrpc class generated from the
		 * protobuf definition.
		 */
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		// stubs -- generate from proto
		blockingStub = StockRoomServiceGrpc.newBlockingStub(channel);

		asyncStub = StockRoomServiceGrpc.newStub(channel);

		// Calls the readyOrder(), stockSupply(), and StockAlert() functions to interact
		// with the server.
		readyOrder(null, blockingStub);

		stockSupply(0, blockingStub);

		StockAlert(blockingStub); //

	}

	// Unary RPC
	public static void readyOrder(String clientname, StockRoomServiceBlockingStub blockingstub) {
		try {/// Create a new OrderRequestt object with the specified order ID and client
				/// name
			OrderRequestt request = OrderRequestt.newBuilder().setOrderid("").setOrderid("80098")
					.setClientname("Pedro Luiz").build();

			// Call the readyOrder RPC method on the server using the blocking stub and the
			// OrderRequestt object
			ReadyResponse repply = blockingstub.readyOrder(request);
			System.out.println("Checking if order is ready to delivery..." + repply.getOrderStatus());// Print the order
																										// status
																										// returned by
																										// the server

		} catch (StatusRuntimeException ex) {
			ex.printStackTrace();//// If an exception is thrown, print the stack trace
		}

	}

//Unary RPC	
	public static void stockSupply(int currentQty, StockRoomServiceBlockingStub blokingstub) {
		try {
			int num1 = 220;// The current qtity of one item
			int num2 = 30;// Simulates the quantity of an item being supplied.

			StockSupplyRequest req = StockSupplyRequest.newBuilder().setCurrentQty(num1).setInputQty(num2).build();

			// Response from the server is then stored in the response variable(req), which
			// is of type StockSupplyResponse.
			StockSupplyResponse response = blockingStub.stockSupply(req);

			// prints out the result of the stockSupply() operation. It concatenates a
			// string that includes the result and mysupply fields of the response object.
			System.out.println("\n\nCheking quantity of Losartana into stock => "
					+ response.getResult() + " units \n" + response.getMysupply());
		} catch (StatusRuntimeException ex) {
			ex.printStackTrace();
		}

	}

//Server stream 
	public static void StockAlert(StockRoomServiceBlockingStub blockingStub) {

		try {
			AlertRequest request = AlertRequest.newBuilder().setItemname("Losartana").setMinStockLevel(5).build();

			StreamObserver<AlertResponse> responseObserver = new StreamObserver<AlertResponse>() {

				int count = 0;

				// @Override
				public void onNext(AlertResponse value) {
					System.out.println("\nReceived alert message: " + value.getMessage());
					count += 1;
				}

				@Override
				public void onError(Throwable t) {
					System.err.println("Error occurred during streaming: " + t.getMessage());
				}

				@Override
				public void onCompleted() {
					System.out.println("Streaming completed " + count + " message of alert");
					System.out.println("server completed");

				}
			};
			asyncStub.stockAlert(request, responseObserver);

			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// Handle any errors that occur during the sleep period
			e.printStackTrace();
		}

	}

}