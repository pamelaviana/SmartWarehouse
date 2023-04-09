package com.proto.StockRoomService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceImplBase;
import com.proto.StockRoomService.StockSupplyRequest.Operation;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.Server;

//import io.grpc.stub.StreamObserver;




public class StockRoomServer extends StockRoomServiceImplBase {
public static void main(String[]args) {
//instance of salesService
StockRoomServer stockRoom = new StockRoomServer();
int port = 50052;


Server server;

try {
server = ServerBuilder.forPort(port).addService(stockRoom ).build().start();
System.out.println("StockRoom Server started...");
server.awaitTermination(); 
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}catch (InterruptedException e) {
e.printStackTrace();
} 
}


@Override
public void readyOrder(OrderRequest request, StreamObserver<ReadyResponse> responseObserver) {
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
	    int minStockLevel = request.getMinStockLevel();

	    // TODO: implement logic to check stock levels and send alerts when necessary
	    // For demonstration purposes, we will simply send a single alert message indicating that the stock level is low
	    String alertMessage = "Low stock for item " + itemName;

	    // Send the alert message back to the client
	    AlertResponse response = AlertResponse.newBuilder().setMessage(alertMessage).build();
	    responseObserver.onNext(response);

	    int count = 0;
	    String lastAlertMessage = "";
	    // Continuously check the stock level and send additional alerts when necessary
	    while (count < 5) {
	        // TODO: implement logic to check stock levels and send alerts when necessary
	        Map<String, Integer> stockLevels = new HashMap<>();
	        stockLevels.put("Losartana ", 10);
	       
	        for (String productName : stockLevels.keySet()) {
	            int currentStockLevel = stockLevels.get(productName);
	            if (currentStockLevel < minStockLevel) {
	                // The current stock level is below the minimum
	                String message = "Low stock for item: " + productName;
	                if (!message.equals(lastAlertMessage)) {
	                    // Only send the message if it's different from the last one sent
	                    AlertResponse alert = AlertResponse.newBuilder().setMessage(message).build();
	                    responseObserver.onNext(alert);
	                    lastAlertMessage = message;
	                    count = 1;
	                } else {
	                    // Increment the count if the message is the same as the last one sent
	                    count++;
	                }
	            } else {
	                // The current stock level is above or equal to the minimum
	                System.out.println("Stock level is sufficient for item => " + productName);
	            }
	        }


	        // Wait for a short period of time before checking the stock level again
	        try {
	            Thread.sleep(1000); // Sleep for 1 second
	        } catch (InterruptedException e) {
	            // Handle any errors that occur during the sleep period
	            e.printStackTrace();
	        }
	    }
	}
}









