package com.proto.salesService;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.FileInputStream;
import java.io.InputStream;




	public class SalesRegistration {
		static int port = 50053;


		public static void main ( String[] args) throws InterruptedException, IOException {
					
			Properties prop = SalesRegistration.getProperties();
			SalesRegistration.registerService(prop);


			int port = Integer.valueOf( prop.getProperty("service_port") );// #.9099;

		
			
			try {
				Server server = ServerBuilder
					.forPort(port).addService(new SalesServiceServer())
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

			 try (InputStream input = new FileInputStream("src/main/resources/salesService.properties")) {

		            prop = new Properties();

		         // load a properties file
		            prop.load(input);

		            // get the property value and print it out
		            System.out.println("Sales Service Service properies ...");
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
		            String service_type = prop.getProperty("service_type") ;//"_salesservice._tcp.local.";
		            String service_name = prop.getProperty("service_name")  ;// "example";
		            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.9099;

			
		            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
		            // Register a service
		            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
		            jmdns.registerService(serviceInfo);
		            
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



	}		