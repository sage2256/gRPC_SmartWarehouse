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
		 int port = 50053;
		 
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
	private boolean isLightOn = false;
	@Override
	public StreamObserver<BrightnessLevel> brightness(StreamObserver<LightStatus> responseObserver) {
		// TODO Auto-generated method stub
		//return super.brightness(responseObserver);
		 return new StreamObserver<BrightnessLevel>() {
	            @Override
	            public void onNext(BrightnessLevel value) {
	                float brightnessLevel = value.getLevel();
	                if (brightnessLevel == 0) {
	                    brightnessLevel = 1.0f;
	                } else if (brightnessLevel == 1.0) {
	                    brightnessLevel = 0.0f;
	                }
	                System.out.println("Received brightness level: " + brightnessLevel);
	                isLightOn = brightnessLevel == 1;
	                responseObserver.onNext(LightStatus.newBuilder().setOn(isLightOn).build());
	            }

	            @Override
	            public void onCompleted() {
	                System.out.println("Brightness stream completed");
	                responseObserver.onCompleted();
	            }

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
	        };
	}

	@Override
	public StreamObserver<OccupancyStatus> switch_(StreamObserver<LightStatus> responseObserver) {
		// TODO Auto-generated method stub
		//return super.switch_(responseObserver);
		return new StreamObserver<OccupancyStatus>() {
            @Override
            public void onNext(OccupancyStatus value) {
                boolean isOccupied = value.getOccupied();
                System.out.println("Received occupancy status: " + isOccupied);
                isLightOn = isOccupied;
                responseObserver.onNext(LightStatus.newBuilder().setOn(isLightOn).build());
            }

            @Override
            public void onCompleted() {
                System.out.println("Switch stream completed");
                responseObserver.onCompleted();
            }

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}
        };
	}

	@Override
	public void remote(RemoteRequest request, StreamObserver<Confirmation> responseObserver) {
		// TODO Auto-generated method stub
		//super.remote(request, responseObserver);
		 boolean turnOn = request.getOn();
	        System.out.println("Received remote request to turn " + (turnOn ? "on" : "off") + " the light");
	        
	        Confirmation confirmation = Confirmation.newBuilder()
	                .setMessage("The light has been turned " + (turnOn ? "on" : "off"))
	                .build();

	        responseObserver.onNext(confirmation);
	        responseObserver.onCompleted();
	}

	

}
