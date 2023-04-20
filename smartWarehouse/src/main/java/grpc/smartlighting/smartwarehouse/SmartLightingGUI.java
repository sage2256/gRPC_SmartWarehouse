package grpc.smartlighting.smartwarehouse;

import javax.swing.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class SmartLightingGUI extends JFrame {
    private static SmartLightingServiceGrpc.SmartLightingServiceStub stub;

    public SmartLightingGUI() {
        int port = 50053;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();
        stub = SmartLightingServiceGrpc.newStub(channel);

        switchLight(true);
        setBrightness(0.7f);
        switchLight(false);

        channel.shutdown();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("Smart Lighting GUI");
        setVisible(true);
    }

    public static void switchLight(boolean isOccupied) {
        StreamObserver<OccupancyStatus> requestObserver = stub.switch_(new StreamObserver<LightStatus>() {
            @Override
            public void onNext(LightStatus value) {
                System.out.println("Light is " + (value.getOn() ? "on" : "off"));
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Switch completed");
            }
        });

        requestObserver.onNext(OccupancyStatus.newBuilder().setOccupied(isOccupied).build());
        requestObserver.onCompleted();
    }

    public static void setBrightness(float brightnessLevel) {
        StreamObserver<BrightnessLevel> requestObserver = stub.brightness(new StreamObserver<LightStatus>() {
            @Override
            public void onNext(LightStatus value) {
                System.out.println("Light is " + (value.getOn() ? "on" : "off"));
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Brightness set completed");
            }
        });

        requestObserver.onNext(BrightnessLevel.newBuilder().setLevel(brightnessLevel).build());
        requestObserver.onCompleted();
    }

    public static void main(String[] args) {
        new SmartLightingGUI();
    }
}
