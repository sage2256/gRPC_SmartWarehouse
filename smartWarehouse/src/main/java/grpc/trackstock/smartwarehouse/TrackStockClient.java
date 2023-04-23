package grpc.trackstock.smartwarehouse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class TrackStockClient {
	// Initialize the gRPC channel and stub
    private final ManagedChannel channel;
    private final TrackStockServiceGrpc.TrackStockServiceStub stub;
    // Create a channel with the given resolved IP address and port
    public TrackStockClient(String resolvedIP, int port) {
        channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
        stub = TrackStockServiceGrpc.newStub(channel);
    }
    // method to add a new item to the warehouse
    public void addItem(StockItem item, StreamObserver<Confirmation> responseObserver) {
    	// Call the gRPC method "add" and pass the StockItem and a response observer to handle the confirmation
        stub.add(item, responseObserver);
    }
    // method to remove an item from the warehouse
    public void removeItem(StockItem item, StreamObserver<Confirmation> responseObserver) {
        stub.remove(item, responseObserver);
    }
    // method to list the available items in the warehouse
    public void listItems(int numItems, StreamObserver<StockItem> responseObserver) {
        stub.list(ListRequest.newBuilder().setListItems(numItems).build(), responseObserver);
    }
    // Shutdown the channel and wait for termination
    public void shutdown() throws InterruptedException {
    	// Gracefully shutdown the channel and wait up to 5 seconds for it to terminate
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
