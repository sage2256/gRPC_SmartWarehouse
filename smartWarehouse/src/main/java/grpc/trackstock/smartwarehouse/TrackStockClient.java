package grpc.trackstock.smartwarehouse;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class TrackStockClient {
	
	private static TrackStockServiceGrpc.TrackStockServiceStub stub;

	public static void main(String[] args) {
		int port = 50054;
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
		stub = TrackStockServiceGrpc.newStub(channel);
		
		// Example usage of the gRPC API
		addItem();
		removeItem();
		listItems();
		
		channel.shutdown();
	}
	
	public static void addItem() {
		StreamObserver<Confirmation> responseObserver = new StreamObserver<Confirmation>() {
			@Override
			public void onNext(Confirmation value) {
				System.out.println("Add Item Response: " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Add Item Request completed");
			}
		};
		
		StockItem item = StockItem.newBuilder().setId(1).setName("Item 1").setQuantity(10).build();
		stub.add(item, responseObserver);
	}
	
	public static void removeItem() {
		StreamObserver<Confirmation> responseObserver = new StreamObserver<Confirmation>() {
			@Override
			public void onNext(Confirmation value) {
				System.out.println("Remove Item Response: " + value.getMessage());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Remove Item Request completed");
			}
		};
		
		StockItem item = StockItem.newBuilder().setId(1).setName("Item 1").setQuantity(10).build();
		stub.remove(item, responseObserver);
	}
	
	public static void listItems() {
		StreamObserver<StockItem> responseObserver = new StreamObserver<StockItem>() {
			@Override
			public void onNext(StockItem value) {
				System.out.println("List Item Response: " + value.getName() + ", " + value.getQuantity());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("Error: " + t.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("List Item Request completed");
			}
		};
		
		ListRequest request = ListRequest.newBuilder().setListItems(10).build();
		stub.list(request, responseObserver);
	}
}
