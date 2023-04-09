package com.proto.StockRoomService;

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
 * <pre>
 *Service Definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: StockRoomService.proto")
public final class StockRoomServiceGrpc {

  private StockRoomServiceGrpc() {}

  public static final String SERVICE_NAME = "com.proto.StockRoomService.StockRoomService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.StockRoomService.OrderRequest,
      com.proto.StockRoomService.ReadyResponse> getReadyOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readyOrder",
      requestType = com.proto.StockRoomService.OrderRequest.class,
      responseType = com.proto.StockRoomService.ReadyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.StockRoomService.OrderRequest,
      com.proto.StockRoomService.ReadyResponse> getReadyOrderMethod() {
    io.grpc.MethodDescriptor<com.proto.StockRoomService.OrderRequest, com.proto.StockRoomService.ReadyResponse> getReadyOrderMethod;
    if ((getReadyOrderMethod = StockRoomServiceGrpc.getReadyOrderMethod) == null) {
      synchronized (StockRoomServiceGrpc.class) {
        if ((getReadyOrderMethod = StockRoomServiceGrpc.getReadyOrderMethod) == null) {
          StockRoomServiceGrpc.getReadyOrderMethod = getReadyOrderMethod = 
              io.grpc.MethodDescriptor.<com.proto.StockRoomService.OrderRequest, com.proto.StockRoomService.ReadyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.proto.StockRoomService.StockRoomService", "readyOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.ReadyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockRoomServiceMethodDescriptorSupplier("readyOrder"))
                  .build();
          }
        }
     }
     return getReadyOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.StockRoomService.StockSupplyRequest,
      com.proto.StockRoomService.StockSupplyResponse> getStockSupplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stockSupply",
      requestType = com.proto.StockRoomService.StockSupplyRequest.class,
      responseType = com.proto.StockRoomService.StockSupplyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.StockRoomService.StockSupplyRequest,
      com.proto.StockRoomService.StockSupplyResponse> getStockSupplyMethod() {
    io.grpc.MethodDescriptor<com.proto.StockRoomService.StockSupplyRequest, com.proto.StockRoomService.StockSupplyResponse> getStockSupplyMethod;
    if ((getStockSupplyMethod = StockRoomServiceGrpc.getStockSupplyMethod) == null) {
      synchronized (StockRoomServiceGrpc.class) {
        if ((getStockSupplyMethod = StockRoomServiceGrpc.getStockSupplyMethod) == null) {
          StockRoomServiceGrpc.getStockSupplyMethod = getStockSupplyMethod = 
              io.grpc.MethodDescriptor.<com.proto.StockRoomService.StockSupplyRequest, com.proto.StockRoomService.StockSupplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.proto.StockRoomService.StockRoomService", "stockSupply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.StockSupplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.StockSupplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockRoomServiceMethodDescriptorSupplier("stockSupply"))
                  .build();
          }
        }
     }
     return getStockSupplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.StockRoomService.AlertRequest,
      com.proto.StockRoomService.AlertResponse> getStockAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stockAlert",
      requestType = com.proto.StockRoomService.AlertRequest.class,
      responseType = com.proto.StockRoomService.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.StockRoomService.AlertRequest,
      com.proto.StockRoomService.AlertResponse> getStockAlertMethod() {
    io.grpc.MethodDescriptor<com.proto.StockRoomService.AlertRequest, com.proto.StockRoomService.AlertResponse> getStockAlertMethod;
    if ((getStockAlertMethod = StockRoomServiceGrpc.getStockAlertMethod) == null) {
      synchronized (StockRoomServiceGrpc.class) {
        if ((getStockAlertMethod = StockRoomServiceGrpc.getStockAlertMethod) == null) {
          StockRoomServiceGrpc.getStockAlertMethod = getStockAlertMethod = 
              io.grpc.MethodDescriptor.<com.proto.StockRoomService.AlertRequest, com.proto.StockRoomService.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.proto.StockRoomService.StockRoomService", "stockAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.StockRoomService.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockRoomServiceMethodDescriptorSupplier("stockAlert"))
                  .build();
          }
        }
     }
     return getStockAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockRoomServiceStub newStub(io.grpc.Channel channel) {
    return new StockRoomServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockRoomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockRoomServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockRoomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockRoomServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static abstract class StockRoomServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void readyOrder(com.proto.StockRoomService.OrderRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.ReadyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadyOrderMethod(), responseObserver);
    }

    /**
     */
    public void stockSupply(com.proto.StockRoomService.StockSupplyRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.StockSupplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStockSupplyMethod(), responseObserver);
    }

    /**
     */
    public void stockAlert(com.proto.StockRoomService.AlertRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.AlertResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStockAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReadyOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.StockRoomService.OrderRequest,
                com.proto.StockRoomService.ReadyResponse>(
                  this, METHODID_READY_ORDER)))
          .addMethod(
            getStockSupplyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.StockRoomService.StockSupplyRequest,
                com.proto.StockRoomService.StockSupplyResponse>(
                  this, METHODID_STOCK_SUPPLY)))
          .addMethod(
            getStockAlertMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.StockRoomService.AlertRequest,
                com.proto.StockRoomService.AlertResponse>(
                  this, METHODID_STOCK_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class StockRoomServiceStub extends io.grpc.stub.AbstractStub<StockRoomServiceStub> {
    private StockRoomServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockRoomServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockRoomServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockRoomServiceStub(channel, callOptions);
    }

    /**
     */
    public void readyOrder(com.proto.StockRoomService.OrderRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.ReadyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadyOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stockSupply(com.proto.StockRoomService.StockSupplyRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.StockSupplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStockSupplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stockAlert(com.proto.StockRoomService.AlertRequest request,
        io.grpc.stub.StreamObserver<com.proto.StockRoomService.AlertResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStockAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class StockRoomServiceBlockingStub extends io.grpc.stub.AbstractStub<StockRoomServiceBlockingStub> {
    private StockRoomServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockRoomServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockRoomServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockRoomServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.StockRoomService.ReadyResponse readyOrder(com.proto.StockRoomService.OrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadyOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.StockRoomService.StockSupplyResponse stockSupply(com.proto.StockRoomService.StockSupplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getStockSupplyMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.proto.StockRoomService.AlertResponse> stockAlert(
        com.proto.StockRoomService.AlertRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStockAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class StockRoomServiceFutureStub extends io.grpc.stub.AbstractStub<StockRoomServiceFutureStub> {
    private StockRoomServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockRoomServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockRoomServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockRoomServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.StockRoomService.ReadyResponse> readyOrder(
        com.proto.StockRoomService.OrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadyOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.StockRoomService.StockSupplyResponse> stockSupply(
        com.proto.StockRoomService.StockSupplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStockSupplyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READY_ORDER = 0;
  private static final int METHODID_STOCK_SUPPLY = 1;
  private static final int METHODID_STOCK_ALERT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockRoomServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockRoomServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_READY_ORDER:
          serviceImpl.readyOrder((com.proto.StockRoomService.OrderRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.StockRoomService.ReadyResponse>) responseObserver);
          break;
        case METHODID_STOCK_SUPPLY:
          serviceImpl.stockSupply((com.proto.StockRoomService.StockSupplyRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.StockRoomService.StockSupplyResponse>) responseObserver);
          break;
        case METHODID_STOCK_ALERT:
          serviceImpl.stockAlert((com.proto.StockRoomService.AlertRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.StockRoomService.AlertResponse>) responseObserver);
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

  private static abstract class StockRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockRoomServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.StockRoomService.StockRoomServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockRoomService");
    }
  }

  private static final class StockRoomServiceFileDescriptorSupplier
      extends StockRoomServiceBaseDescriptorSupplier {
    StockRoomServiceFileDescriptorSupplier() {}
  }

  private static final class StockRoomServiceMethodDescriptorSupplier
      extends StockRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockRoomServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StockRoomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockRoomServiceFileDescriptorSupplier())
              .addMethod(getReadyOrderMethod())
              .addMethod(getStockSupplyMethod())
              .addMethod(getStockAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
