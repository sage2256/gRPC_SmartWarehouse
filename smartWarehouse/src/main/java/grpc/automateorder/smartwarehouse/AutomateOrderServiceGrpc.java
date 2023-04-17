package grpc.automateorder.smartwarehouse;

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
    comments = "Source: AutomateOrder.proto")
public final class AutomateOrderServiceGrpc {

  private AutomateOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "smartwarehouse.AutomateOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.Confirmation> getMakeOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeOrder",
      requestType = grpc.automateorder.smartwarehouse.OrderRequest.class,
      responseType = grpc.automateorder.smartwarehouse.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.Confirmation> getMakeOrderMethod() {
    io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.Confirmation> getMakeOrderMethod;
    if ((getMakeOrderMethod = AutomateOrderServiceGrpc.getMakeOrderMethod) == null) {
      synchronized (AutomateOrderServiceGrpc.class) {
        if ((getMakeOrderMethod = AutomateOrderServiceGrpc.getMakeOrderMethod) == null) {
          AutomateOrderServiceGrpc.getMakeOrderMethod = getMakeOrderMethod = 
              io.grpc.MethodDescriptor.<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.AutomateOrderService", "MakeOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new AutomateOrderServiceMethodDescriptorSupplier("MakeOrder"))
                  .build();
          }
        }
     }
     return getMakeOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.Confirmation> getStopOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopOrder",
      requestType = grpc.automateorder.smartwarehouse.OrderRequest.class,
      responseType = grpc.automateorder.smartwarehouse.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.Confirmation> getStopOrderMethod() {
    io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.Confirmation> getStopOrderMethod;
    if ((getStopOrderMethod = AutomateOrderServiceGrpc.getStopOrderMethod) == null) {
      synchronized (AutomateOrderServiceGrpc.class) {
        if ((getStopOrderMethod = AutomateOrderServiceGrpc.getStopOrderMethod) == null) {
          AutomateOrderServiceGrpc.getStopOrderMethod = getStopOrderMethod = 
              io.grpc.MethodDescriptor.<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.AutomateOrderService", "StopOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new AutomateOrderServiceMethodDescriptorSupplier("StopOrder"))
                  .build();
          }
        }
     }
     return getStopOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.OrderStatus> getStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Status",
      requestType = grpc.automateorder.smartwarehouse.OrderRequest.class,
      responseType = grpc.automateorder.smartwarehouse.OrderStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest,
      grpc.automateorder.smartwarehouse.OrderStatus> getStatusMethod() {
    io.grpc.MethodDescriptor<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.OrderStatus> getStatusMethod;
    if ((getStatusMethod = AutomateOrderServiceGrpc.getStatusMethod) == null) {
      synchronized (AutomateOrderServiceGrpc.class) {
        if ((getStatusMethod = AutomateOrderServiceGrpc.getStatusMethod) == null) {
          AutomateOrderServiceGrpc.getStatusMethod = getStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.automateorder.smartwarehouse.OrderRequest, grpc.automateorder.smartwarehouse.OrderStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.AutomateOrderService", "Status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.automateorder.smartwarehouse.OrderStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new AutomateOrderServiceMethodDescriptorSupplier("Status"))
                  .build();
          }
        }
     }
     return getStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutomateOrderServiceStub newStub(io.grpc.Channel channel) {
    return new AutomateOrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutomateOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AutomateOrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutomateOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AutomateOrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AutomateOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeOrder(grpc.automateorder.smartwarehouse.OrderRequest request,
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeOrderMethod(), responseObserver);
    }

    /**
     */
    public void stopOrder(grpc.automateorder.smartwarehouse.OrderRequest request,
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getStopOrderMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.OrderRequest> status(
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.OrderStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.automateorder.smartwarehouse.OrderRequest,
                grpc.automateorder.smartwarehouse.Confirmation>(
                  this, METHODID_MAKE_ORDER)))
          .addMethod(
            getStopOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.automateorder.smartwarehouse.OrderRequest,
                grpc.automateorder.smartwarehouse.Confirmation>(
                  this, METHODID_STOP_ORDER)))
          .addMethod(
            getStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.automateorder.smartwarehouse.OrderRequest,
                grpc.automateorder.smartwarehouse.OrderStatus>(
                  this, METHODID_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class AutomateOrderServiceStub extends io.grpc.stub.AbstractStub<AutomateOrderServiceStub> {
    private AutomateOrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutomateOrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomateOrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AutomateOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void makeOrder(grpc.automateorder.smartwarehouse.OrderRequest request,
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopOrder(grpc.automateorder.smartwarehouse.OrderRequest request,
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStopOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.OrderRequest> status(
        io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.OrderStatus> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AutomateOrderServiceBlockingStub extends io.grpc.stub.AbstractStub<AutomateOrderServiceBlockingStub> {
    private AutomateOrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutomateOrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomateOrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AutomateOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.automateorder.smartwarehouse.Confirmation makeOrder(grpc.automateorder.smartwarehouse.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.automateorder.smartwarehouse.Confirmation stopOrder(grpc.automateorder.smartwarehouse.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getStopOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AutomateOrderServiceFutureStub extends io.grpc.stub.AbstractStub<AutomateOrderServiceFutureStub> {
    private AutomateOrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutomateOrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomateOrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AutomateOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.automateorder.smartwarehouse.Confirmation> makeOrder(
        grpc.automateorder.smartwarehouse.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.automateorder.smartwarehouse.Confirmation> stopOrder(
        grpc.automateorder.smartwarehouse.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStopOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_ORDER = 0;
  private static final int METHODID_STOP_ORDER = 1;
  private static final int METHODID_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutomateOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutomateOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_ORDER:
          serviceImpl.makeOrder((grpc.automateorder.smartwarehouse.OrderRequest) request,
              (io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation>) responseObserver);
          break;
        case METHODID_STOP_ORDER:
          serviceImpl.stopOrder((grpc.automateorder.smartwarehouse.OrderRequest) request,
              (io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.Confirmation>) responseObserver);
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
        case METHODID_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.status(
              (io.grpc.stub.StreamObserver<grpc.automateorder.smartwarehouse.OrderStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AutomateOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutomateOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutomateOrderService");
    }
  }

  private static final class AutomateOrderServiceFileDescriptorSupplier
      extends AutomateOrderServiceBaseDescriptorSupplier {
    AutomateOrderServiceFileDescriptorSupplier() {}
  }

  private static final class AutomateOrderServiceMethodDescriptorSupplier
      extends AutomateOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutomateOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutomateOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutomateOrderServiceFileDescriptorSupplier())
              .addMethod(getMakeOrderMethod())
              .addMethod(getStopOrderMethod())
              .addMethod(getStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
