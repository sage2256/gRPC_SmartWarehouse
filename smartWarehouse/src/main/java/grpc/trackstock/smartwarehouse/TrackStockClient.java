package grpc.trackstock.smartwarehouse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class TrackStockClient {

    private final ManagedChannel channel;
    private final TrackStockServiceGrpc.TrackStockServiceStub stub;

    public TrackStockClient(String resolvedIP, int port) {
        channel = ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext().build();
        stub = TrackStockServiceGrpc.newStub(channel);
    }

    public void addItem(StockItem item, StreamObserver<Confirmation> responseObserver) {
        stub.add(item, responseObserver);
    }

    public void removeItem(StockItem item, StreamObserver<Confirmation> responseObserver) {
        stub.remove(item, responseObserver);
    }

    public void listItems(int numItems, StreamObserver<StockItem> responseObserver) {
        stub.list(ListRequest.newBuilder().setListItems(numItems).build(), responseObserver);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
