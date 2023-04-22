package grpc.smartlighting.smartwarehouse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartLightingClient {
    private final SmartLightingServiceGrpc.SmartLightingServiceStub stub;
    private final ManagedChannel channel;

    public SmartLightingClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public SmartLightingClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        stub = SmartLightingServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

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
