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
	
	
	
	
	public static void main(String[]args) {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50052)
				.usePlaintext()
				.build();
		//stubs -- generate from proto
		blockingStub = StockRoomServiceGrpc.newBlockingStub(channel);

		asyncStub = StockRoomServiceGrpc.newStub(channel);
		
	
	
		readyOrder(null, blockingStub);

		System.out.println("============================================================================");
                
        StockAlert(blockingStub);

        System.out.println("============================================================================");
                
        stockSupply(0, blockingStub);

        System.out.println("============================================================================");
                
                
		
	}

	public static void readyOrder(String clientname,StockRoomServiceBlockingStub blockingstub) {
		try {
		OrderRequestt request = OrderRequestt.newBuilder().setOrderid("")
				.setOrderid("80098")
				.setClientname("Pedro Luiz")
				.build();
				ReadyResponse repply = blockingstub.readyOrder (request);
				System.out.println("Checking if order is ready to delivery..." + repply.getOrderStatus());
			
				
   } catch (StatusRuntimeException ex) {
       ex.printStackTrace();
   }
   
}

	
	
public static void stockSupply(int currentQty,StockRoomServiceBlockingStub blokingstub ) {
	try {
	int num1 = 220;
	int num2 = 30;

	StockSupplyRequest  req = StockSupplyRequest .newBuilder().setCurrentQty(num1).setInputQty (num2).build();

	StockSupplyResponse response = blockingStub.stockSupply(req);

	System.out.println("Cheking quantity of Losartana after insert 220units into stock => " + response.getResult() + " units into stock " + response.getMysupply());
	  } catch (StatusRuntimeException ex) {
	       ex.printStackTrace();
	   }
	   
	}
	



public static void StockAlert(StockRoomServiceBlockingStub blockingStub)  {
    
	  // Wait for a short period of time before closing the channel
   
     try {
        AlertRequest request = AlertRequest.newBuilder().setItemname("Losartana").setMinStockLevel(5).build();
        

		StreamObserver<AlertResponse> responseObserver = new StreamObserver<AlertResponse>() {
            
			int count= 0;
			
			//@Override
            public void onNext(AlertResponse value) {
                System.out.println("Received alert message: " + value.getMessage());
                count +=1;
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error occurred during streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Streaming completed "+count+" alerta");
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