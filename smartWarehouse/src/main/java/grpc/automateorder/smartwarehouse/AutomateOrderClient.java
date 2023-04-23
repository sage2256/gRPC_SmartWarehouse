package grpc.automateorder.smartwarehouse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import smartwarehouse.AutomateOrder.Confirmation;
import smartwarehouse.AutomateOrder.OrderRequest;
import smartwarehouse.AutomateOrder.OrderStatus;
import smartwarehouse.AutomateOrderServiceGrpc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AutomateOrderClient {
	// Declaring instance variables for the class
    private final ManagedChannel channel;
    private final AutomateOrderServiceGrpc.AutomateOrderServiceBlockingStub blockingStub;
    private final AutomateOrderServiceGrpc.AutomateOrderServiceStub asyncStub;
    // Constructor to create a new instance of AutomateOrderClient with IP address and port number
    public AutomateOrderClient(String resolvedIP, int port) {
        this(ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build());
    }
    // Constructor to create a new instance of AutomateOrderClient with an existing ManagedChannel
    public AutomateOrderClient(ManagedChannel channel) {
    	// Initializing the instance variables with the given ManagedChannel
        this.channel = channel;
        blockingStub = AutomateOrderServiceGrpc.newBlockingStub(channel);
        asyncStub = AutomateOrderServiceGrpc.newStub(channel);
    }
    // Method to shutdown the channel
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    // Method to create an order with the specified fields
    public String makeOrder(String itemName, int quantity, String customerName) {
        OrderRequest request = OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build();
        // Calling the makeOrder method from the blocking stub
        Confirmation confirmation = blockingStub.makeOrder(request);
        // Printing the confirmation message and returning it
        System.out.println("Order confirmation received: " + confirmation.getMessage());
		return confirmation.getMessage();
    }
    // Method to stop an order with the specified fields
    public void stopOrder(String itemName, int quantity, String customerName) {
    	// Building an OrderRequest object with the given parameters
        OrderRequest request = OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build();
        // Calling the stopOrder method from the blocking stub to stop the order and receive confirmation
        Confirmation confirmation = blockingStub.stopOrder(request);
        // Printing the confirmation message
        System.out.println("Order stop confirmation received: " + confirmation.getMessage());
    }
    // Method to stream the status of an order with the specified fields
    public void streamOrderStatus(String itemName, int quantity, String customerName) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        // Create a StreamObserver object that listens for OrderStatus objects
        StreamObserver<OrderRequest> requestObserver = asyncStub.status(new StreamObserver<OrderStatus>() {
            @Override
            public void onNext(OrderStatus orderStatus) {
                System.out.println("Order status received: " + orderStatus.getMessage());
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error in streaming order status: " + throwable.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Order status streaming completed");
                finishLatch.countDown();
            }
        });
        // Send an OrderRequest object to the server with the specified fields
        requestObserver.onNext(OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build());
        // Notify the server that there are no more requests to send
        requestObserver.onCompleted();

        finishLatch.await(1, TimeUnit.MINUTES);
    }
}

