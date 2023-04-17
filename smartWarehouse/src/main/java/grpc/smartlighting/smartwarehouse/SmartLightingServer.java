package grpc.smartlighting.smartwarehouse;

import java.io.IOException;

import grpc.smartlighting.smartwarehouse.SmartLightingServiceGrpc.SmartLightingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartLightingServer extends SmartLightingServiceImplBase{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SmartLightingServer LightingServer = new SmartLightingServer();
		 int port = 50052;
		 
		 Server server;
		try {
			server = ServerBuilder.forPort(port).addService(LightingServer).build().start();
			System.out.println("Server started....");
			server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
	}

	@Override
	public StreamObserver<BrightnessLevel> brightness(StreamObserver<LightStatus> responseObserver) {
		// TODO Auto-generated method stub
		return super.brightness(responseObserver);
	}

	@Override
	public StreamObserver<OccupancyStatus> switch_(StreamObserver<LightStatus> responseObserver) {
		// TODO Auto-generated method stub
		return super.switch_(responseObserver);
	}

	@Override
	public void remote(RemoteRequest request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		super.remote(request, responseObserver);
	}

	

}
