package com.proto.LogiHubService;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.proto.LogiHubService.LogiHubServiceGrpc.LogiHubServiceBlockingStub;
import com.proto.LogiHubService.LogiHubServiceGrpc.LogiHubServiceStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GUIImplementation {
	
	private static LogiHubServiceStub nonblockingstub;
	

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("LoguiHub server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
        //stubs -- generate from proto
        LogiHubServiceBlockingStub blockingStub = LogiHubServiceGrpc.newBlockingStub(channel);
        LogiHubServiceStub asyncStub = LogiHubServiceGrpc.newStub(channel);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

        JPanel panelText = new JPanel();
        panel.setLayout(new BorderLayout());

		JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension( 450, 480 ) );
        textPane.setEditable(false);

		JButton deliverystatusButton = new JButton("Check delivery status ");
		JButton failureButton = new JButton("Failure Order ");
		JButton returnorderButton = new JButton("return Order");

		panel.add(deliverystatusButton, BorderLayout.NORTH);
		panel.add(failureButton, BorderLayout.CENTER);
		panel.add(returnorderButton, BorderLayout.SOUTH);
        panelText.add(textPane, BorderLayout.CENTER);

		frame.getContentPane().add(panel, BorderLayout.WEST);
		frame.getContentPane().add(panelText, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(460,480);

		deliverystatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String status = "Your order has already been chipped";
                try {
                	StatusRequest request = StatusRequest.newBuilder()
                    		.setOrderid("1345")
                    		 .setClientname("Pamela Quintanilha")
                    		.setMydelivery(status)
                    		.build();
                StatusResponse reply = blockingStub.deliveryStatus(request);
                    textPane.setText("");
                    textPane.setText(" I wanna know about my delivery status!\n\n" + reply.getMystatus());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                    
                }
			}
		});

		failureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	FailureRequest failureRequest = FailureRequest.newBuilder()
                            .setOrderid("1234")
                            .setItemname("Losartan")
                            .setReason("Product broken in shipping.")
                            .build();
                	  FailureResponse failureResponse = blockingStub.failureOrder(failureRequest);
                    textPane.setText("");
                    textPane.setText("Identified order Failure in transport -  \n\n" + failureResponse.getConfirmation());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                    
                }
			}
		});

		returnorderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                	ReturnRequest returnRequest = ReturnRequest.newBuilder()
                            .setOrderid("5678")
                            .setClientname("Oseias Viana")
                            .setReason("The product does not match the description")
                            .build();
                	  ReturnResponse returnResponse = blockingStub.returnOrder(returnRequest);
                    textPane.setText("");
                    textPane.setText(" Return request - \n" + returnResponse.getConfirmation());
                } catch (StatusRuntimeException ex) {
                    ex.printStackTrace();
                    
                
                }
			}
		});
	}
}
