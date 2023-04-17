package com.proto.StockRoomService;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceImplBase;
import com.proto.StockRoomService.StockSupplyRequest.Operation;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//import io.grpc.stub.StreamObserver;




public class StockRoomServer extends StockRoomServiceImplBase {
	static int port = 50052;


	public static void main ( String[] args) throws InterruptedException, IOException {
				
		Properties prop = StockRoomServer.getProperties();
		StockRoomServer.registerService(prop);


		int port = Integer.valueOf( prop.getProperty("service_port") );// #.9099;

	
		
		try {
			Server server = ServerBuilder
				.forPort(port).addService(new StockRoomServer())
				.build();
		server.start();
		
		System.out.println(" Server 1 started at  "  + port);
	

		server.awaitTermination();

		} catch (IOException | InterruptedException e) {
			System.err.println("Error starting server");
			e.printStackTrace();

		}
			
	}	
	
	
	private static Properties getProperties() {
		
		Properties prop = null;		

		 try (InputStream input = new FileInputStream("src/main/resources/StockRoomService.properties")) {

	            prop = new Properties();

	         // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("StockRoom Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));
		 } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	
	private static  void registerService(Properties prop) {
		
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            String service_type = prop.getProperty("service_type") ;//"_stockRoomService._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50054;
	            
	          
		
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            // Register a service
	            ServiceInfo service3Info = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(service3Info);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
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







@Override
public void readyOrder(OrderRequestt request, StreamObserver<ReadyResponse> responseObserver) {
	System.out.print("receiving client message ");
	
	
	String orderId =request.getOrderid();
      String clientName = request.getClientname();
     
    	
      String mystatus = "\n The follow order has been checked into stock: "+"\nOrder ID: "+orderId+"\nClient name: "+clientName+" \nThis order is ready to delivery!!";


      ReadyResponse response = ReadyResponse.newBuilder()
            .setOrderStatus(mystatus)
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();        
}


@Override
public void stockSupply(StockSupplyRequest request, StreamObserver<StockSupplyResponse> responseObserver) {
	System.out.println("receiving  stockSupply method " + request.getCurrentQty() + " , " + request.getInputQty () + "HHH " + request.getOperation() );

	float value = Float.NaN;
	String msg= "";

	if(	request.getOperation()== Operation.ADDITION)
		value = request.getCurrentQty() + request.getInputQty ();
	
	else  {
		value = Float.NaN;
		msg = "no supported/implemented operation";
	}		
StockSupplyResponse reply = StockSupplyResponse .newBuilder().setResult(value).setMysupply (msg).build();

	responseObserver.onNext(reply);

	responseObserver.onCompleted();
}
	



//Server streaming
@Override
public void stockAlert(AlertRequest request, StreamObserver<AlertResponse> responseObserver) {
	  String itemName = request.getItemname();


	    // TODO: implement logic to check stock levels and send alerts when necessary
	    // For demonstration purposes, we will simply send a single alert message indicating that the stock level is low
	    String alertMessage = "Low stock for item " + itemName;

	    // Send the alert message back to the client
	    AlertResponse response = AlertResponse.newBuilder().setMessage(alertMessage).build();
//	    responseObserver.onNext(response);


            Map<String, Integer> stockLevels = new HashMap<>();
	    stockLevels.put("Losartana", 10);
	    
            for(int i =0; i<= 5 ; i++) {
	        // TODO: implement logic to check stock levels and send alerts when necessary
	    
                // The current stock level is below the minimum
                System.out.println("Low stock for item: " + itemName);
                System.out.println(i);
                
                responseObserver.onNext(response);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StockRoomServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                }
            
                responseObserver.onCompleted();
	      
	    }
	
}