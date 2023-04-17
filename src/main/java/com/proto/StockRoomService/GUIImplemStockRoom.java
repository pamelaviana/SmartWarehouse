package com.proto.StockRoomService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceBlockingStub;
import com.proto.StockRoomService.StockRoomServiceGrpc.StockRoomServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class GUIImplemStockRoom {
	
	public static void main(String[] args) {
	JFrame  frame = new JFrame ("StockRoom Service start");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
	
	//stubs --- generate from proto
	
	StockRoomServiceBlockingStub blockingStub = StockRoomServiceGrpc.newBlockingStub(channel);
	StockRoomServiceStub asyncStub = StockRoomServiceGrpc.newStub(channel);
	
	
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	
	JPanel panelText = new JPanel();
	panel.setLayout(new BorderLayout());
	
	JTextPane textPane = new JTextPane();
    textPane.setPreferredSize(new Dimension( 450, 480 ) );
    textPane.setEditable(false);
    
    JButton readyOrderButton = new JButton("check if order is ready to delivery");
	JButton stockSupplyButton = new JButton("Stock supply");
	JButton StockAlertButton = new JButton("Stock alert");
	
	panel.add(readyOrderButton, BorderLayout.NORTH);
	panel.add(stockSupplyButton , BorderLayout.CENTER);
	panel.add(StockAlertButton, BorderLayout.SOUTH);
    panelText.add(textPane, BorderLayout.CENTER);
    
    frame.getContentPane().add(panel, BorderLayout.WEST);
	frame.getContentPane().add(panelText, BorderLayout.EAST);
	frame.pack();
	frame.setVisible(true);
	frame.setSize(640,480);
	
	

	
	
	
	readyOrderButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				OrderRequestt request = OrderRequestt.newBuilder().setOrderid("")
						.setOrderid("80098")
						.setClientname("Pedro Luiz")
						.build();
				ReadyResponse repply = blockingStub.readyOrder (request);
				
				 textPane.setText("");
				textPane.setText("Checking if order is ready to delivery..." + repply.getOrderStatus());
				System.out.println("============================================================================");
				
   } catch (StatusRuntimeException ex) {
       ex.printStackTrace();
   }
}
});
	
	stockSupplyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
            try {
            	int num1 = 220;
            	int num2 = 30;

            	StockSupplyRequest  req = StockSupplyRequest .newBuilder().setCurrentQty(num1).setInputQty (num2).build();

            	StockSupplyResponse response = blockingStub.stockSupply(req);
            
            	 textPane.setText("");
            	textPane.setText("Cheking quantity of Losartana after insert 220units into stock => " + response.getResult() + " units into stock " + response.getMysupply());
				
            } catch (StatusRuntimeException ex) {
                ex.printStackTrace();
            }
         }
         });
	
	
	StockAlertButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
            
            	  AlertRequest request = AlertRequest.newBuilder().setItemname("Losartana").setMinStockLevel(5).build();
                  

          		
            		StreamObserver<AlertResponse> responseObserver = new StreamObserver<AlertResponse>() {
                        
            			int count= 0;
            			
            			//@Override
                        public void onNext(AlertResponse value) {
                        	 textPane.setText("");
                        	textPane.setText("Received alert message: " + value.getMessage());
                            count +=1;
                        }

                        @Override
                        public void onError(Throwable t) {
                            System.err.println("Error occurred during streaming: " + t.getMessage());
                        }

                        @Override
                        public void onCompleted() {
                        	textPane.setText("Streaming completed "+count+" alerta");
                        }
            		};
            		asyncStub.stockAlert(request, responseObserver);
                        
               
                    
                    // Wait for a short period of time before closing the channel
                  
                        Thread.sleep(20000); 
                    } catch (InterruptedException ex) {
                        // Handle any errors that occur during the sleep period
                        ex.printStackTrace();
                    }
            }
            
		});
             
	}
	}
                      
		


    

	
	
	
	
	