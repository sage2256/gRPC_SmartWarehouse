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
    private String orderStatus = "In progress";

    public static void main(String[] args) {
         AutomateOrderServer orderServer = new AutomateOrderServer();
         int port = 50092;
         
         Server server;
        try {
            server = ServerBuilder.forPort(port).addService(orderServer).build().start();
            System.out.println("Server started....");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
         
    }

    @Override
    public void makeOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
        System.out.println("---- Receiving Make order request from Client ---");
        
        String message = "Order created for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();
    }

    @Override
    public void stopOrder(OrderRequest request, StreamObserver<Confirmation> responseObserver) {
        String message = "Order stopped for " + request.getQuantity() + " " + request.getItemName() + "(s) for " + request.getCustomerName();
        Confirmation confirmation = Confirmation.newBuilder().setMessage(message).build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();

        // Update order status to "Terminated"
        orderStatus = "Terminated";
    }
    

    @Override
    public StreamObserver<OrderRequest> status(StreamObserver<OrderStatus> responseObserver) {
        return new StreamObserver<OrderRequest>() {
            @Override
            public void onNext(OrderRequest request) {
                String itemName = request.getItemName();
                int quantity = request.getQuantity();
                String customerName = request.getCustomerName();

                // Construct order status message
                String statusMessage = "Order status for " + itemName + " (quantity: " + quantity +
                        ") requested by " + customerName + ": " + orderStatus;

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
