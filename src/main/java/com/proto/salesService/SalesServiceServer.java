// Name of the package where all the generated files are present.
package com.proto.salesService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.proto.salesService.SalesServiceGrpc.SalesServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SalesServiceServer extends SalesServiceImplBase {

	static int port = 50053;

	// Main method would contain the logic to start the server.
	public static void main(String[] args) throws InterruptedException, IOException {

		// Get the properties for the Sales Service from a configuration file.
		Properties prop = SalesServiceServer.getProperties();
		SalesServiceServer.registerService(prop);

		// Get the port number from the properties obtained from the configuration file
		int port = Integer.valueOf(prop.getProperty("service_port"));// #.50053;

		try {//// Create a gRPC Server and add the SalesServiceServer implementation to it.
			Server server = ServerBuilder.forPort(port).addService(new SalesServiceServer()).build();
			server.start();// Start the gRPC Server

			System.out.println(" Sale Server started at  " + port);

			server.awaitTermination();// Wait for the server to terminate

		} catch (IOException | InterruptedException e) {
			System.err.println("Error starting server");
			e.printStackTrace();

		}

	}

	private static Properties getProperties() {

		Properties prop = null;

		try (InputStream input = new FileInputStream("src/main/resources/salesService.properties")) {

			prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println("Sales Service Service properies ...");
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return prop;
	}

	// Register the Sales Service with jmDNS using the provided properties
	private static void registerService(Properties prop) {

		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			String service_type = prop.getProperty("service_type");// "_salesservice._tcp.local.";
			String service_name = prop.getProperty("service_name");// "example";
			int service_port = Integer.valueOf(prop.getProperty("service_port"));// #.9099;

			String service_description_properties = prop.getProperty("service_description");// "path=index.html";
			// Register a service
			ServiceInfo service2Info = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(service2Info);

			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

			// Wait for 1 second
			Thread.sleep(1000);

			// Unregister all services
			jmdns.unregisterAllServices();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Client stream
	@Override
	public StreamObserver<OrderRequest> sendOrder(StreamObserver<OrderResponse> responseObserver) {

		// Retrieve the value from the stream of requests of the client.
		return new StreamObserver<OrderRequest>() {

			String receipt = " ";// to store the order details as they are received from the client.

			// called for each OrderRequest message received from the client. It appends the
			// order details to the receipt string variable,
			// and then logs a message to the console.
			@Override
			public void onNext(OrderRequest orderRequest) {
				receipt += "\n The followinh Order has been received:\n" + " Client ID: " + orderRequest.getClientid()
						+ " Order ID: " + orderRequest.getOrderid() + " Phone Number: " + orderRequest.getPhonenumber()
						+ " Purchase Price: " + orderRequest.getPurchaseprice() + " Product Name: "
						+ orderRequest.getProductname() + " Quantity: " + orderRequest.getQuantity()
						+ "\n We are checking the payment.";

				System.out.println("===============================================================");

			}

			@Override
			public void onError(Throwable t) {// This method is called if there is an error with the stream.
				// TODO Auto-generated method stub

			}

			// Once the complete stream is received this logic will be executed.
			@Override
			public void onCompleted() {

				OrderResponse res = OrderResponse.newBuilder().setMymessage(receipt).build();
				responseObserver.onNext(res);
				// responseObserver.onCompleted();

				System.out.println("===============================================================");
			}
		};
	}

	// Unary RPC
	@Override
	public void checkPayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {

		// Logical code
		String orderId = request.getOrderid();
		String clientName = request.getClientname();
		double paymentTotal = request.getPaymenttotal();

		String mypayment = "\nThe follow payment: " + "\nOrder ID: " + orderId + "\nClient name: " + clientName
				+ "\nPayment total: " + paymentTotal + " \nhas been authorized!!";

		// Build a response message

		PaymentResponse res = PaymentResponse.newBuilder().setPaymentstatus(mypayment).build();

		// Send the response back to the client
		responseObserver.onNext(res);
		responseObserver.onCompleted();
	}

	// RPC Bidirectional Streaming.
	@Override
	public StreamObserver<FeedbackRequest> feedback(StreamObserver<FeedbackResponse> responseObserver) {

		StreamObserver<FeedbackRequest> requestObserver = new StreamObserver<FeedbackRequest>() {
			@Override
			public void onNext(FeedbackRequest value) {

				String response = "Thank you for your feedback. We appreciate it! => ( " + value.getFeedbackClient()
						+ " )";

				// Preparing and sending the reply for the client.
				FeedbackResponse feedbackresponse = FeedbackResponse.newBuilder().setMessage(response).build();

				// Sending the reply for each request.
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
