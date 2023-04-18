package com.proto.ErrorHandlingInterceptor;


import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;

public class JmDnsServiceDiscovery {

    public static void main(String[] args) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("JmDNS Listening...");

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getInfo());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getInfo());
                }
            });

            // Wait a bit
            Thread.sleep(3000);

            // Close JmDNS
            jmdns.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
