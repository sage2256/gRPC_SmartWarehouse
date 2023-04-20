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

    private final ManagedChannel channel;
    private final AutomateOrderServiceGrpc.AutomateOrderServiceBlockingStub blockingStub;
    private final AutomateOrderServiceGrpc.AutomateOrderServiceStub asyncStub;

    public AutomateOrderClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    public AutomateOrderClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = AutomateOrderServiceGrpc.newBlockingStub(channel);
        asyncStub = AutomateOrderServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String makeOrder(String itemName, int quantity, String customerName) {
        OrderRequest request = OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build();

        Confirmation confirmation = blockingStub.makeOrder(request);
        System.out.println("Order confirmation received: " + confirmation.getMessage());
		return confirmation.getMessage();
    }

    public void stopOrder(String itemName, int quantity, String customerName) {
        OrderRequest request = OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build();

        Confirmation confirmation = blockingStub.stopOrder(request);
        System.out.println("Order stop confirmation received: " + confirmation.getMessage());
    }

    public void streamOrderStatus(String itemName, int quantity, String customerName) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

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

        requestObserver.onNext(OrderRequest.newBuilder()
                .setItemName(itemName)
                .setQuantity(quantity)
                .setCustomerName(customerName)
                .build());

        requestObserver.onCompleted();

        finishLatch.await(1, TimeUnit.MINUTES);
    }
}

