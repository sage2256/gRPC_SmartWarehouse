package grpc.smartlighting.smartwarehouse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartLightingClient {
	// gRPC stub and channel instances
    private final SmartLightingServiceGrpc.SmartLightingServiceStub stub;
    private final ManagedChannel channel;
   
    // Constructor to create a new SmartLightingClien
    public SmartLightingClient(String resolvedIP, int port) {
    	// Build a channel to the specified IP address and port
        this(ManagedChannelBuilder.forAddress(resolvedIP, port).usePlaintext());
    }
    // Constructor to create a new SmartLightingClient with a given channel builder
    public SmartLightingClient(ManagedChannelBuilder<?> channelBuilder) {
    	// Build a channel using the provided channel builder
        channel = channelBuilder.build();
        // Create a new gRPC stub for SmartLightingService
        stub = SmartLightingServiceGrpc.newStub(channel);
    }
    // Shutdown the channel and wait for termination
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
    // Method to adjust the brightness of the lighting
    public void brightness(float level) {
        stub.brightness(new StreamObserver<LightStatus>() {
            @Override
            public void onNext(LightStatus value) {
                System.out.println("Received light status: " + value.getOn());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Brightness stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Brightness stream completed");
            }
        }).onNext(BrightnessLevel.newBuilder().setLevel(level).build());
    }
    // Method to switch the light on or off depending on occupancy status
    public void switchLight(boolean isOccupied) {
        stub.switch_(new StreamObserver<LightStatus>() {
            @Override
            public void onNext(LightStatus value) {
                System.out.println("Received light status: " + value.getOn());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Switch stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Switch stream completed");
            }
        }).onNext(OccupancyStatus.newBuilder().setOccupied(isOccupied).build());
    }
    // Method to remotely turn on or off the lighting
    public void remote(boolean turnOn) {
        stub.remote(RemoteRequest.newBuilder().setOn(turnOn).build(), new StreamObserver<Confirmation>() {
            @Override
            public void onNext(Confirmation value) {
                System.out.println("Received confirmation message: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Remote request error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Remote request completed");
            }
        });
    }
       
}
