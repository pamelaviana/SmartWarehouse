package com.proto.LogiHubService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
//import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import com.proto.LogiHubService.LogiHubServiceGrpc.LogiHubServiceImplBase;



//required grpc package for the server side
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class LogiHubServer extends LogiHubServiceImplBase {

//private static final Logger logger = Logger.getLogger(LogiHubServer.class.getName());
//OTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
public static void main(String[] args) {
	
LogiHubServer logihubservice = new LogiHubServer();

Properties prop = logihubservice.getProperties();

logihubservice.registerService1(prop);

int port = 50054;
//int port = Integer.valueOf( prop.getProperty("service_port") );// #.50054;

try {
Server server = ServerBuilder.forPort(port) // Port is defined in line 34
.addService(logihubservice) // Service is defined in line 31
.build() // Build the server
.start(); // Start the server and keep it running for clients to contact.

//Giving a logging information on the server console that server has started
System.out.println("LogiHubServer started, listening on " + port);
//Server will be running until externally terminated.

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
try (InputStream input = new FileInputStream("src/main/resources/LogiHubService.properties")) {
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
private void registerService1(Properties prop) {

	try {
//Create a JmDNS instance
JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
String service_name = prop.getProperty("service_name") ;// "logihubservice";

//int service_port = 1234;
int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50054;
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

		
//Server gRPC Unary
	@Override
	public void deliveryStatus(StatusRequest request, StreamObserver<StatusResponse> responseObserver) {
		// TODO Auto-generated method stub
		
		String orderId =request.getOrderid();
	      String clientname = request.getClientname();
	      String mydelivery = request.getMydelivery();
	    
	      String mystatus = "\n The actual delivery status for the follow client is:  "+"\nOrder ID: "+orderId+"\nClient name: "+clientname+"\nDelivery status: "+mydelivery+"\nWe will let you know about a new status. Thank you for buying with us! ";

	
	    StatusResponse response = StatusResponse.newBuilder()
	            .setMystatus(mystatus)
	            .build();
	    responseObserver.onNext(response);
	    responseObserver.onCompleted();        
	}
	
	
	
     //gRPC unary
	@Override
	public void failureOrder(FailureRequest request, StreamObserver<FailureResponse> responseObserver) {
		// TODO Auto-generated method stub 
		String orderId =request.getOrderid();
		String itemName = request.getItemname();
	      String reason = request.getReason();
	      
	String myFailure = "\nThe follow faiulure: "+"\nOrder ID: "+orderId+"\nItem name: "+itemName+"\nReason: "+reason+" \n was confirmed!!";
	
	      // Build a response message
	      FailureResponse response = FailureResponse.newBuilder()
	                                               .setConfirmation(myFailure)
	                                               .build();

	      // Send the response back to the client
	      responseObserver.onNext(response);
	      responseObserver.onCompleted();
	  }
	
	
	
	 //gRPC unary
	@Override
	public void returnOrder(ReturnRequest request, StreamObserver<ReturnResponse> responseObserver) {
		// TODO Auto-generated method stub
		String orderId = request.getOrderid();
		String clientName = request.getClientname();
	      String reason = request.getReason();
	      
	      String myreturn = "\nThe follow return: "+"\nOrder ID: "+orderId+"\nClient name: "+clientName+"\nReason: "+reason+"\n was received!!";

	      // Build a response message
	      ReturnResponse response = ReturnResponse.newBuilder()
	                                               .setConfirmation(myreturn)
	                                               .build();

	      // Send the response back to the client
	      responseObserver.onNext(response);
	      responseObserver.onCompleted(); 
	      
        
	  }
}
	
	

