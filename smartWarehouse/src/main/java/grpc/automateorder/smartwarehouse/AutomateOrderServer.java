package grpc.automateorder.smartwarehouse;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import smartwarehouse.AutomateOrder.Confirmation;
import smartwarehouse.AutomateOrder.OrderRequest;
import smartwarehouse.AutomateOrder.OrderStatus;
import smartwarehouse.AutomateOrderServiceGrpc.AutomateOrderServiceImplBase;

public class AutomateOrderServer extends AutomateOrderServiceImplBase{
	public static void main(String[] args) {
		 AutomateOrderServer orderServer = new AutomateOrderServer();
		 int port = 50092;
		 
		 Server server;
		try {
			server = ServerBuilder.forPort(port).addService(orderServer).build().start();
			System.out.println("Server started....");
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	@Override
	public void makeOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		//super.makeOrder(request, responseObserver);
		 // TODO: Process the order request and send a confirmation
		System.out.println("---- Receiving Make order request from Client ---");
		
        String message = "Order created for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();
	}

	@Override
	public void stopOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		//super.stopOrder(request, responseObserver);
		   // TODO: Stop the order and send a confirmation
        String message = "Order stopped for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();
    }
	

	@Override
	public StreamObserver<OrderRequest> status(StreamObserver<OrderStatus> responseObserver) {
		// TODO Auto-generated method stub
		//return super.status(responseObserver);
		  // TODO: Stream updates on the status of the order
	    return new StreamObserver<OrderRequest>() {
	        @Override
	        public void onNext(OrderRequest request) {
	            String itemName = request.getItemName();
	            int quantity = request.getQuantity();
	            String customerName = request.getCustomerName();

	            // Logic to retrieve order status
	            String statusMessage = "Order status for " + itemName + " (quantity: " + quantity +
	                    ") requested by " + customerName + ": " + "In progress";

	            OrderStatus orderStatus = OrderStatus.newBuilder()
	                    .setMessage(statusMessage)
	                    .build();

	            responseObserver.onNext(orderStatus);
	        }

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
	
}
