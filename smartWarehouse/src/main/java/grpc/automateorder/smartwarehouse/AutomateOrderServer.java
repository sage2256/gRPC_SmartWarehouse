package grpc.automateorder.smartwarehouse;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smartwarehouse.AutomateOrder.Confirmation;
import smartwarehouse.AutomateOrder.OrderRequest;
import smartwarehouse.AutomateOrder.OrderStatus;
import smartwarehouse.AutomateOrderServiceGrpc.AutomateOrderServiceImplBase;

public class AutomateOrderServer extends AutomateOrderServiceImplBase{
    private String orderStatus = "In progress";

    public static void main(String[] args) {
         AutomateOrderServer orderServer = new AutomateOrderServer();
         int port = 50092; // Defines the port to be used
         orderServer.registerService();  // Call the registerService() method to register the service
         Server server;
        try { // Creates and starts the gRPC server 
            server = ServerBuilder.forPort(port).addService(orderServer).build().start();
            System.out.println("Server started....");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
         
    }
    
    // Implement the makeOrder() method
    @Override
    public void makeOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
        System.out.println("---- Receiving Make order request from Client ---");
        // Create the order message
        String message = "Order created for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();
    }
    
    // Implement the stopOrder() method
    @Override
    public void stopOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
    	// Create the stop order message
        String message = "Order stopped for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();

        // Update order status to "Terminated"
        orderStatus = "Terminated";
    }
    
    // Implement the status() method
    @Override
    public StreamObserver<OrderRequest> status(StreamObserver<OrderStatus> responseObserver) {
        return new StreamObserver<OrderRequest>() {
            @Override
            public void onNext(OrderRequest request) {
            	 // Extracts the order details from the order request
                String itemName = request.getItemName();
                int quantity = request.getQuantity();
                String customerName = request.getCustomerName();

                // Construct order status message
                String statusMessage = "Order status for " + itemName + " (quantity: " + quantity +
                        ") requested by " + customerName + ": " + orderStatus;
                // Build and send the statusMessage response
                OrderStatus orderStatus = OrderStatus.newBuilder()
                        .setMessage(statusMessage)
                        .build();

                responseObserver.onNext(orderStatus);
            }
            
            //Error handling
            @Override
            public void onError(Throwable t) {
                // Handle error
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
    // Define the registerService() method
    private void registerService() {
		
		 try { // Create a JmDNS instance      
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_order._tcp.local.";
	            String service_name = "automate order";
	           
	            int port = 50092;

	            
	            String service_description = "automate order service For Warehouse";
	            // Register the service with the JmDNS instance
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, port, service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}
    
}
