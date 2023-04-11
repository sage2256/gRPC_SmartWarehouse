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
    comments = "Source: TrackStock.proto")
public final class TrackStockServiceGrpc {

  private TrackStockServiceGrpc() {}

  public static final String SERVICE_NAME = "smartwarehouse.TrackStockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smartwarehouse.StockItem,
      smartwarehouse.Confirmation> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = smartwarehouse.StockItem.class,
      responseType = smartwarehouse.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smartwarehouse.StockItem,
      smartwarehouse.Confirmation> getAddMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.StockItem, smartwarehouse.Confirmation> getAddMethod;
    if ((getAddMethod = TrackStockServiceGrpc.getAddMethod) == null) {
      synchronized (TrackStockServiceGrpc.class) {
        if ((getAddMethod = TrackStockServiceGrpc.getAddMethod) == null) {
          TrackStockServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.StockItem, smartwarehouse.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.TrackStockService", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.StockItem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackStockServiceMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartwarehouse.StockItem,
      smartwarehouse.Confirmation> getRemoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Remove",
      requestType = smartwarehouse.StockItem.class,
      responseType = smartwarehouse.Confirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smartwarehouse.StockItem,
      smartwarehouse.Confirmation> getRemoveMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.StockItem, smartwarehouse.Confirmation> getRemoveMethod;
    if ((getRemoveMethod = TrackStockServiceGrpc.getRemoveMethod) == null) {
      synchronized (TrackStockServiceGrpc.class) {
        if ((getRemoveMethod = TrackStockServiceGrpc.getRemoveMethod) == null) {
          TrackStockServiceGrpc.getRemoveMethod = getRemoveMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.StockItem, smartwarehouse.Confirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.TrackStockService", "Remove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.StockItem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.Confirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackStockServiceMethodDescriptorSupplier("Remove"))
                  .build();
          }
        }
     }
     return getRemoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartwarehouse.ListRequest,
      smartwarehouse.StockItem> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = smartwarehouse.ListRequest.class,
      responseType = smartwarehouse.StockItem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<smartwarehouse.ListRequest,
      smartwarehouse.StockItem> getListMethod() {
    io.grpc.MethodDescriptor<smartwarehouse.ListRequest, smartwarehouse.StockItem> getListMethod;
    if ((getListMethod = TrackStockServiceGrpc.getListMethod) == null) {
      synchronized (TrackStockServiceGrpc.class) {
        if ((getListMethod = TrackStockServiceGrpc.getListMethod) == null) {
          TrackStockServiceGrpc.getListMethod = getListMethod = 
              io.grpc.MethodDescriptor.<smartwarehouse.ListRequest, smartwarehouse.StockItem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartwarehouse.TrackStockService", "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartwarehouse.StockItem.getDefaultInstance()))
                  .setSchemaDescriptor(new TrackStockServiceMethodDescriptorSupplier("List"))
                  .build();
          }
        }
     }
     return getListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrackStockServiceStub newStub(io.grpc.Channel channel) {
    return new TrackStockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackStockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrackStockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrackStockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrackStockServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TrackStockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(smartwarehouse.StockItem request,
        io.grpc.stub.StreamObserver<smartwarehouse.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void remove(smartwarehouse.StockItem request,
        io.grpc.stub.StreamObserver<smartwarehouse.Confirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveMethod(), responseObserver);
    }

    /**
     */
    public void list(smartwarehouse.ListRequest request,
        io.grpc.stub.StreamObserver<smartwarehouse.StockItem> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smartwarehouse.StockItem,
                smartwarehouse.Confirmation>(
                  this, METHODID_ADD)))
          .addMethod(
            getRemoveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smartwarehouse.StockItem,
                smartwarehouse.Confirmation>(
                  this, METHODID_REMOVE)))
          .addMethod(
            getListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                smartwarehouse.ListRequest,
                smartwarehouse.StockItem>(
                  this, METHODID_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class TrackStockServiceStub extends io.grpc.stub.AbstractStub<TrackStockServiceStub> {
    private TrackStockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackStockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackStockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackStockServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(smartwarehouse.StockItem request,
        io.grpc.stub.StreamObserver<smartwarehouse.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void remove(smartwarehouse.StockItem request,
        io.grpc.stub.StreamObserver<smartwarehouse.Confirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(smartwarehouse.ListRequest request,
        io.grpc.stub.StreamObserver<smartwarehouse.StockItem> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TrackStockServiceBlockingStub extends io.grpc.stub.AbstractStub<TrackStockServiceBlockingStub> {
    private TrackStockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackStockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackStockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackStockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public smartwarehouse.Confirmation add(smartwarehouse.StockItem request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public smartwarehouse.Confirmation remove(smartwarehouse.StockItem request) {
      return blockingUnaryCall(
          getChannel(), getRemoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<smartwarehouse.StockItem> list(
        smartwarehouse.ListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrackStockServiceFutureStub extends io.grpc.stub.AbstractStub<TrackStockServiceFutureStub> {
    private TrackStockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrackStockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackStockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrackStockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartwarehouse.Confirmation> add(
        smartwarehouse.StockItem request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartwarehouse.Confirmation> remove(
        smartwarehouse.StockItem request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_REMOVE = 1;
  private static final int METHODID_LIST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrackStockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrackStockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((smartwarehouse.StockItem) request,
              (io.grpc.stub.StreamObserver<smartwarehouse.Confirmation>) responseObserver);
          break;
        case METHODID_REMOVE:
          serviceImpl.remove((smartwarehouse.StockItem) request,
              (io.grpc.stub.StreamObserver<smartwarehouse.Confirmation>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((smartwarehouse.ListRequest) request,
              (io.grpc.stub.StreamObserver<smartwarehouse.StockItem>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrackStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackStockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smartwarehouse.TrackStock.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrackStockService");
    }
  }

  private static final class TrackStockServiceFileDescriptorSupplier
      extends TrackStockServiceBaseDescriptorSupplier {
    TrackStockServiceFileDescriptorSupplier() {}
  }

  private static final class TrackStockServiceMethodDescriptorSupplier
      extends TrackStockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrackStockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrackStockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrackStockServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getRemoveMethod())
              .addMethod(getListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
