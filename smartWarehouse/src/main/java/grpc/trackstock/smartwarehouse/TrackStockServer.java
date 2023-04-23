package grpc.trackstock.smartwarehouse;

import java.io.IOException;
import java.net.InetAddress;

import grpc.trackstock.smartwarehouse.TrackStockServiceGrpc.TrackStockServiceImplBase;
import io.grpc.Server;
import java.util.ArrayList;
import java.util.List;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.stub.StreamObserver;
import io.grpc.ServerBuilder;

public class TrackStockServer extends TrackStockServiceImplBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 TrackStockServer StockServer = new  TrackStockServer();// Create an instance of the TrackStockServer
				 int port = 50054; // Define port number
				 StockServer.registerService();
				 
				 Server server; // Declare a variable to hold the server instance
				try {
					server = ServerBuilder.forPort(port).addService(StockServer).build().start();
					System.out.println("Server started....");
					server.awaitTermination(); //syntax to Wait for the server to terminate
				} catch (IOException | InterruptedException e) { // Handle any exceptions thrown during server creation or termination
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

	}
	
	private List<StockItem> inventory = new ArrayList<StockItem>();// Syntax Declare a new list to hold the inventory of the stock

	@Override
	public void add(StockItem request, StreamObserver<Confirmation> responseObserver) {//method to add an item to the inventory
		// TODO Auto-generated method stub
		//super.add(request, responseObserver);
		inventory.add(request);// Add the requested StockItem to the inventory
        Confirmation confirmation = Confirmation.newBuilder()
                .setSuccess(true)
                .setMessage("Item added to inventory")
                //syntax to Create a Confirmation message indicating the success of the operation
                .build();
        responseObserver.onNext(confirmation); // Send the Confirmation message back to the client
        responseObserver.onCompleted();// Indicate to the client that the operation is complete
	}

	@Override
	public void remove(StockItem request, StreamObserver<Confirmation> responseObserver) {//remove method to remove items available in the inventory
		// TODO Auto-generated method stub
		//super.remove(request, responseObserver);
		 if (inventory.contains(request)) {//if statement to remove item if it is available in the inventory
	            inventory.remove(request);
	            Confirmation confirmation = Confirmation.newBuilder()
	                    .setSuccess(true)
	                    .setMessage("Item removed from inventory")
	                    // Create a Confirmation message indicating the success of the removal of the item
	                    .build();
	            responseObserver.onNext(confirmation);
	        } else {
	            Confirmation confirmation = Confirmation.newBuilder()
	                    .setSuccess(false)
	                    .setMessage("Item not found in inventory")
	                    //syntax to Create a Confirmation message indicating the failure of the operation
	                    .build();
	            responseObserver.onNext(confirmation);
	        }
	        responseObserver.onCompleted(); // Indicate to the client that the operation is complete
	}

	@Override
	public void list(ListRequest request, StreamObserver<StockItem> responseObserver) {//method to list all the items available in the inventory
		// TODO Auto-generated method stub
		//super.list(request, responseObserver);
		   int numItems = request.getListItems();// assign the number of items requested
	        for (int i = 0; i < Math.min(numItems, inventory.size()); i++) {// Loop through the inventory to get the requested number of items, or the size of the inventory if there aren't enough item
	            responseObserver.onNext(inventory.get(i)); // Send each requested StockItem back to the client
	        }
	        responseObserver.onCompleted();// Indicate to the client that the operation is complete
	}
	
	private  void registerService() {
		
		 try {
	          
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = "_stock._tcp.local.";
	            String service_name = "smart Lighting";
	           
	            int port = 50054;

	            
	            String service_description = "Track Stock For Warehouse";
	            // Register a service
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
