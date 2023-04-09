package com.proto.LogiHubService;

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
    comments = "Source: LobHubService.proto")
public final class LogiHubServiceGrpc {

  private LogiHubServiceGrpc() {}

  public static final String SERVICE_NAME = "logi_hub.LogiHubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.LogiHubService.StatusRequest,
      com.proto.LogiHubService.StatusResponse> getDeliveryStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeliveryStatus",
      requestType = com.proto.LogiHubService.StatusRequest.class,
      responseType = com.proto.LogiHubService.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.LogiHubService.StatusRequest,
      com.proto.LogiHubService.StatusResponse> getDeliveryStatusMethod() {
    io.grpc.MethodDescriptor<com.proto.LogiHubService.StatusRequest, com.proto.LogiHubService.StatusResponse> getDeliveryStatusMethod;
    if ((getDeliveryStatusMethod = LogiHubServiceGrpc.getDeliveryStatusMethod) == null) {
      synchronized (LogiHubServiceGrpc.class) {
        if ((getDeliveryStatusMethod = LogiHubServiceGrpc.getDeliveryStatusMethod) == null) {
          LogiHubServiceGrpc.getDeliveryStatusMethod = getDeliveryStatusMethod = 
              io.grpc.MethodDescriptor.<com.proto.LogiHubService.StatusRequest, com.proto.LogiHubService.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "logi_hub.LogiHubService", "DeliveryStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.StatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LogiHubServiceMethodDescriptorSupplier("DeliveryStatus"))
                  .build();
          }
        }
     }
     return getDeliveryStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.LogiHubService.FailureRequest,
      com.proto.LogiHubService.FailureResponse> getFailureOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailureOrder",
      requestType = com.proto.LogiHubService.FailureRequest.class,
      responseType = com.proto.LogiHubService.FailureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.LogiHubService.FailureRequest,
      com.proto.LogiHubService.FailureResponse> getFailureOrderMethod() {
    io.grpc.MethodDescriptor<com.proto.LogiHubService.FailureRequest, com.proto.LogiHubService.FailureResponse> getFailureOrderMethod;
    if ((getFailureOrderMethod = LogiHubServiceGrpc.getFailureOrderMethod) == null) {
      synchronized (LogiHubServiceGrpc.class) {
        if ((getFailureOrderMethod = LogiHubServiceGrpc.getFailureOrderMethod) == null) {
          LogiHubServiceGrpc.getFailureOrderMethod = getFailureOrderMethod = 
              io.grpc.MethodDescriptor.<com.proto.LogiHubService.FailureRequest, com.proto.LogiHubService.FailureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "logi_hub.LogiHubService", "FailureOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.FailureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.FailureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LogiHubServiceMethodDescriptorSupplier("FailureOrder"))
                  .build();
          }
        }
     }
     return getFailureOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.LogiHubService.ReturnRequest,
      com.proto.LogiHubService.ReturnResponse> getReturnOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReturnOrder",
      requestType = com.proto.LogiHubService.ReturnRequest.class,
      responseType = com.proto.LogiHubService.ReturnResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.LogiHubService.ReturnRequest,
      com.proto.LogiHubService.ReturnResponse> getReturnOrderMethod() {
    io.grpc.MethodDescriptor<com.proto.LogiHubService.ReturnRequest, com.proto.LogiHubService.ReturnResponse> getReturnOrderMethod;
    if ((getReturnOrderMethod = LogiHubServiceGrpc.getReturnOrderMethod) == null) {
      synchronized (LogiHubServiceGrpc.class) {
        if ((getReturnOrderMethod = LogiHubServiceGrpc.getReturnOrderMethod) == null) {
          LogiHubServiceGrpc.getReturnOrderMethod = getReturnOrderMethod = 
              io.grpc.MethodDescriptor.<com.proto.LogiHubService.ReturnRequest, com.proto.LogiHubService.ReturnResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "logi_hub.LogiHubService", "ReturnOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.ReturnRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.LogiHubService.ReturnResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LogiHubServiceMethodDescriptorSupplier("ReturnOrder"))
                  .build();
          }
        }
     }
     return getReturnOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LogiHubServiceStub newStub(io.grpc.Channel channel) {
    return new LogiHubServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LogiHubServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LogiHubServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LogiHubServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LogiHubServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LogiHubServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method to search for the status of an order
     * </pre>
     */
    public void deliveryStatus(com.proto.LogiHubService.StatusRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeliveryStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method to inform the warehouse about non-delivery due to unforeseen events
     * </pre>
     */
    public void failureOrder(com.proto.LogiHubService.FailureRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.FailureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFailureOrderMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method to request the return of an item
     * </pre>
     */
    public void returnOrder(com.proto.LogiHubService.ReturnRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.ReturnResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReturnOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDeliveryStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.LogiHubService.StatusRequest,
                com.proto.LogiHubService.StatusResponse>(
                  this, METHODID_DELIVERY_STATUS)))
          .addMethod(
            getFailureOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.LogiHubService.FailureRequest,
                com.proto.LogiHubService.FailureResponse>(
                  this, METHODID_FAILURE_ORDER)))
          .addMethod(
            getReturnOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.LogiHubService.ReturnRequest,
                com.proto.LogiHubService.ReturnResponse>(
                  this, METHODID_RETURN_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class LogiHubServiceStub extends io.grpc.stub.AbstractStub<LogiHubServiceStub> {
    private LogiHubServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LogiHubServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogiHubServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LogiHubServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method to search for the status of an order
     * </pre>
     */
    public void deliveryStatus(com.proto.LogiHubService.StatusRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeliveryStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method to inform the warehouse about non-delivery due to unforeseen events
     * </pre>
     */
    public void failureOrder(com.proto.LogiHubService.FailureRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.FailureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFailureOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method to request the return of an item
     * </pre>
     */
    public void returnOrder(com.proto.LogiHubService.ReturnRequest request,
        io.grpc.stub.StreamObserver<com.proto.LogiHubService.ReturnResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReturnOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LogiHubServiceBlockingStub extends io.grpc.stub.AbstractStub<LogiHubServiceBlockingStub> {
    private LogiHubServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LogiHubServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogiHubServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LogiHubServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method to search for the status of an order
     * </pre>
     */
    public com.proto.LogiHubService.StatusResponse deliveryStatus(com.proto.LogiHubService.StatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeliveryStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Method to inform the warehouse about non-delivery due to unforeseen events
     * </pre>
     */
    public com.proto.LogiHubService.FailureResponse failureOrder(com.proto.LogiHubService.FailureRequest request) {
      return blockingUnaryCall(
          getChannel(), getFailureOrderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Method to request the return of an item
     * </pre>
     */
    public com.proto.LogiHubService.ReturnResponse returnOrder(com.proto.LogiHubService.ReturnRequest request) {
      return blockingUnaryCall(
          getChannel(), getReturnOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LogiHubServiceFutureStub extends io.grpc.stub.AbstractStub<LogiHubServiceFutureStub> {
    private LogiHubServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LogiHubServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogiHubServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LogiHubServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method to search for the status of an order
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.LogiHubService.StatusResponse> deliveryStatus(
        com.proto.LogiHubService.StatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeliveryStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Method to inform the warehouse about non-delivery due to unforeseen events
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.LogiHubService.FailureResponse> failureOrder(
        com.proto.LogiHubService.FailureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFailureOrderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Method to request the return of an item
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.LogiHubService.ReturnResponse> returnOrder(
        com.proto.LogiHubService.ReturnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReturnOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELIVERY_STATUS = 0;
  private static final int METHODID_FAILURE_ORDER = 1;
  private static final int METHODID_RETURN_ORDER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LogiHubServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LogiHubServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELIVERY_STATUS:
          serviceImpl.deliveryStatus((com.proto.LogiHubService.StatusRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.LogiHubService.StatusResponse>) responseObserver);
          break;
        case METHODID_FAILURE_ORDER:
          serviceImpl.failureOrder((com.proto.LogiHubService.FailureRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.LogiHubService.FailureResponse>) responseObserver);
          break;
        case METHODID_RETURN_ORDER:
          serviceImpl.returnOrder((com.proto.LogiHubService.ReturnRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.LogiHubService.ReturnResponse>) responseObserver);
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

  private static abstract class LogiHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LogiHubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.LogiHubService.LogiHubServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LogiHubService");
    }
  }

  private static final class LogiHubServiceFileDescriptorSupplier
      extends LogiHubServiceBaseDescriptorSupplier {
    LogiHubServiceFileDescriptorSupplier() {}
  }

  private static final class LogiHubServiceMethodDescriptorSupplier
      extends LogiHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LogiHubServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LogiHubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LogiHubServiceFileDescriptorSupplier())
              .addMethod(getDeliveryStatusMethod())
              .addMethod(getFailureOrderMethod())
              .addMethod(getReturnOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
