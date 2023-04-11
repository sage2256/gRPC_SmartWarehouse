package smartwarehouse;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SmartLighting.proto")
public final class SmartLightingServiceGrpc {

  private SmartLightingServiceGrpc() {}

  public static final String SERVICE_NAME = "smartwarehouse.SmartLightingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.BrightnessLevel,
      smartwarehouse.SmartLighting.LightStatus> getBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Brightness",
      requestType = smartwarehouse.SmartLighting.BrightnessLevel.class,
      responseType = smartwarehouse.SmartLighting.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.BrightnessLevel,
      smartwarehouse.SmartLighting.LightStatus> getBrightnessMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.BrightnessLevel, smartwarehouse.SmartLighting.LightStatus> getBrightnessMethod;
    if ((getBrightnessMethod = SmartLightingServiceGrpc.getBrightnessMethod) == null) {
      synchronized (SmartLightingServiceGrpc.class) {
        if ((getBrightnessMethod = SmartLightingServiceGrpc.getBrightnessMethod) == null) {
          SmartLightingServiceGrpc.getBrightnessMethod = getBrightnessMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.SmartLighting.BrightnessLevel, smartwarehouse.SmartLighting.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.SmartLightingService", "Brightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.BrightnessLevel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingServiceMethodDescriptorSupplier("Brightness"))
                  .build();
          }
        }
     }
     return getBrightnessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.OccupancyStatus,
      smartwarehouse.SmartLighting.LightStatus> getSwitchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Switch",
      requestType = smartwarehouse.SmartLighting.OccupancyStatus.class,
      responseType = smartwarehouse.SmartLighting.LightStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.OccupancyStatus,
      smartwarehouse.SmartLighting.LightStatus> getSwitchMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.OccupancyStatus, smartwarehouse.SmartLighting.LightStatus> getSwitchMethod;
    if ((getSwitchMethod = SmartLightingServiceGrpc.getSwitchMethod) == null) {
      synchronized (SmartLightingServiceGrpc.class) {
        if ((getSwitchMethod = SmartLightingServiceGrpc.getSwitchMethod) == null) {
          SmartLightingServiceGrpc.getSwitchMethod = getSwitchMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.SmartLighting.OccupancyStatus, smartwarehouse.SmartLighting.LightStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.SmartLightingService", "Switch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.OccupancyStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.LightStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingServiceMethodDescriptorSupplier("Switch"))
                  .build();
          }
        }
     }
     return getSwitchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.RemoteRequest,
      smartwarehouse.SmartLighting.Confirmation> getRemoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Remote",
      requestType = smartwarehouse.SmartLighting.RemoteRequest.class,
      responseType = smartwarehouse.SmartLighting.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.RemoteRequest,
      smartwarehouse.SmartLighting.Confirmation> getRemoteMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.SmartLighting.RemoteRequest, smartwarehouse.SmartLighting.Confirmation> getRemoteMethod;
    if ((getRemoteMethod = SmartLightingServiceGrpc.getRemoteMethod) == null) {
      synchronized (SmartLightingServiceGrpc.class) {
        if ((getRemoteMethod = SmartLightingServiceGrpc.getRemoteMethod) == null) {
          SmartLightingServiceGrpc.getRemoteMethod = getRemoteMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.SmartLighting.RemoteRequest, smartwarehouse.SmartLighting.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.SmartLightingService", "Remote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.RemoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.SmartLighting.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLightingServiceMethodDescriptorSupplier("Remote"))
                  .build();
          }
        }
     }
     return getRemoteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartLightingServiceStub newStub(io.grpc.Channel channel) {
    return new SmartLightingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartLightingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartLightingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartLightingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartLightingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartLightingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.BrightnessLevel> brightness(
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getBrightnessMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.OccupancyStatus> switch_(
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getSwitchMethod(), responseObserver);
    }

    /**
     */
    public void remote(smartwarehouse.SmartLighting.RemoteRequest request,
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBrightnessMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                smartwarehouse.SmartLighting.BrightnessLevel,
                smartwarehouse.SmartLighting.LightStatus>(
                  this, METHODID_BRIGHTNESS)))
          .addMethod(
            getSwitchMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                smartwarehouse.SmartLighting.OccupancyStatus,
                smartwarehouse.SmartLighting.LightStatus>(
                  this, METHODID_SWITCH)))
          .addMethod(
            getRemoteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smartwarehouse.SmartLighting.RemoteRequest,
                smartwarehouse.SmartLighting.Confirmation>(
                  this, METHODID_REMOTE)))
          .build();
    }
  }

  /**
   */
  public static final class SmartLightingServiceStub extends io.grpc.stub.AbstractStub<SmartLightingServiceStub> {
    private SmartLightingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.BrightnessLevel> brightness(
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBrightnessMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.OccupancyStatus> switch_(
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSwitchMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void remote(smartwarehouse.SmartLighting.RemoteRequest request,
        io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SmartLightingServiceBlockingStub extends io.grpc.stub.AbstractStub<SmartLightingServiceBlockingStub> {
    private SmartLightingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public smartwarehouse.SmartLighting.Confirmation remote(smartwarehouse.SmartLighting.RemoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmartLightingServiceFutureStub extends io.grpc.stub.AbstractStub<SmartLightingServiceFutureStub> {
    private SmartLightingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLightingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLightingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLightingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartwarehouse.SmartLighting.Confirmation> remote(
        smartwarehouse.SmartLighting.RemoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REMOTE = 0;
  private static final int METHODID_BRIGHTNESS = 1;
  private static final int METHODID_SWITCH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartLightingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartLightingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REMOTE:
          serviceImpl.remote((smartwarehouse.SmartLighting.RemoteRequest) request,
              (io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.Confirmation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BRIGHTNESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.brightness(
              (io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus>) responseObserver);
        case METHODID_SWITCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.switch_(
              (io.grpc.stub.StreamObserver<smartwarehouse.SmartLighting.LightStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartLightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartLightingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smartwarehouse.SmartLighting.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartLightingService");
    }
  }

  private static final class SmartLightingServiceFileDescriptorSupplier
      extends SmartLightingServiceBaseDescriptorSupplier {
    SmartLightingServiceFileDescriptorSupplier() {}
  }

  private static final class SmartLightingServiceMethodDescriptorSupplier
      extends SmartLightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartLightingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SmartLightingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartLightingServiceFileDescriptorSupplier())
              .addMethod(getBrightnessMethod())
              .addMethod(getSwitchMethod())
              .addMethod(getRemoteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
