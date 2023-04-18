package grpc.trackstock.smartwarehouse;

import java.io.IOException;
import grpc.trackstock.smartwarehouse.TrackStockServiceGrpc.TrackStockServiceImplBase;
import io.grpc.Server;
import java.util.ArrayList;
import java.util.List;
import io.grpc.stub.StreamObserver;
import io.grpc.ServerBuilder;

public class TrackStockServer extends TrackStockServiceImplBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 TrackStockServer StockServer = new  TrackStockServer();
				 int port = 50054;
				 
				 Server server;
				try {
					server = ServerBuilder.forPort(port).addService(StockServer).build().start();
					System.out.println("Server started....");
					server.awaitTermination();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

	}
	
	private List<StockItem> inventory = new ArrayList<StockItem>();

	@Override
	public void add(StockItem request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		//super.add(request, responseObserver);
		inventory.add(request);
        Confirmation confirmation = Confirmation.newBuilder()
                .setSuccess(true)
                .setMessage("Item added to inventory")
                .build();
        responseObserver.onNext(confirmation);
        responseObserver.onCompleted();
	}

	@Override
	public void remove(StockItem request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		//super.remove(request, responseObserver);
		 if (inventory.contains(request)) {
	            inventory.remove(request);
	            Confirmation confirmation = Confirmation.newBuilder()
	                    .setSuccess(true)
	                    .setMessage("Item removed from inventory")
	                    .build();
	            responseObserver.onNext(confirmation);
	        } else {
	            Confirmation confirmation = Confirmation.newBuilder()
	                    .setSuccess(false)
	                    .setMessage("Item not found in inventory")
	                    .build();
	            responseObserver.onNext(confirmation);
	        }
	        responseObserver.onCompleted();
	}

	@Override
	public void list(ListRequest request, StreamObserver<StockItem> responseObserver) {
		// TODO Auto-generated method stub
		//super.list(request, responseObserver);
		   int numItems = request.getListItems();
	        for (int i = 0; i < Math.min(numItems, inventory.size()); i++) {
	            responseObserver.onNext(inventory.get(i));
	        }
	        responseObserver.onCompleted();
	}
		
}
