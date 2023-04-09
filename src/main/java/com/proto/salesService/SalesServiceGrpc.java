package com.proto.salesService;

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
    comments = "Source: SalesService.proto")
public final class SalesServiceGrpc {

  private SalesServiceGrpc() {}

  public static final String SERVICE_NAME = "salesService.SalesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.salesService.OrderRequest,
      com.proto.salesService.OrderResponse> getSendOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendOrder",
      requestType = com.proto.salesService.OrderRequest.class,
      responseType = com.proto.salesService.OrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.salesService.OrderRequest,
      com.proto.salesService.OrderResponse> getSendOrderMethod() {
    io.grpc.MethodDescriptor<com.proto.salesService.OrderRequest, com.proto.salesService.OrderResponse> getSendOrderMethod;
    if ((getSendOrderMethod = SalesServiceGrpc.getSendOrderMethod) == null) {
      synchronized (SalesServiceGrpc.class) {
        if ((getSendOrderMethod = SalesServiceGrpc.getSendOrderMethod) == null) {
          SalesServiceGrpc.getSendOrderMethod = getSendOrderMethod = 
              io.grpc.MethodDescriptor.<com.proto.salesService.OrderRequest, com.proto.salesService.OrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "salesService.SalesService", "SendOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.OrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.OrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SalesServiceMethodDescriptorSupplier("SendOrder"))
                  .build();
          }
        }
     }
     return getSendOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.salesService.PaymentRequest,
      com.proto.salesService.PaymentResponse> getCheckPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckPayment",
      requestType = com.proto.salesService.PaymentRequest.class,
      responseType = com.proto.salesService.PaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.salesService.PaymentRequest,
      com.proto.salesService.PaymentResponse> getCheckPaymentMethod() {
    io.grpc.MethodDescriptor<com.proto.salesService.PaymentRequest, com.proto.salesService.PaymentResponse> getCheckPaymentMethod;
    if ((getCheckPaymentMethod = SalesServiceGrpc.getCheckPaymentMethod) == null) {
      synchronized (SalesServiceGrpc.class) {
        if ((getCheckPaymentMethod = SalesServiceGrpc.getCheckPaymentMethod) == null) {
          SalesServiceGrpc.getCheckPaymentMethod = getCheckPaymentMethod = 
              io.grpc.MethodDescriptor.<com.proto.salesService.PaymentRequest, com.proto.salesService.PaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "salesService.SalesService", "CheckPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.PaymentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SalesServiceMethodDescriptorSupplier("CheckPayment"))
                  .build();
          }
        }
     }
     return getCheckPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.salesService.FeedbackRequest,
      com.proto.salesService.FeedbackResponse> getFeedbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Feedback",
      requestType = com.proto.salesService.FeedbackRequest.class,
      responseType = com.proto.salesService.FeedbackResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.salesService.FeedbackRequest,
      com.proto.salesService.FeedbackResponse> getFeedbackMethod() {
    io.grpc.MethodDescriptor<com.proto.salesService.FeedbackRequest, com.proto.salesService.FeedbackResponse> getFeedbackMethod;
    if ((getFeedbackMethod = SalesServiceGrpc.getFeedbackMethod) == null) {
      synchronized (SalesServiceGrpc.class) {
        if ((getFeedbackMethod = SalesServiceGrpc.getFeedbackMethod) == null) {
          SalesServiceGrpc.getFeedbackMethod = getFeedbackMethod = 
              io.grpc.MethodDescriptor.<com.proto.salesService.FeedbackRequest, com.proto.salesService.FeedbackResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "salesService.SalesService", "Feedback"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.FeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.salesService.FeedbackResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SalesServiceMethodDescriptorSupplier("Feedback"))
                  .build();
          }
        }
     }
     return getFeedbackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SalesServiceStub newStub(io.grpc.Channel channel) {
    return new SalesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SalesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SalesServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SalesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SalesServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static abstract class SalesServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.salesService.OrderRequest> sendOrder(
        io.grpc.stub.StreamObserver<com.proto.salesService.OrderResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendOrderMethod(), responseObserver);
    }

    /**
     */
    public void checkPayment(com.proto.salesService.PaymentRequest request,
        io.grpc.stub.StreamObserver<com.proto.salesService.PaymentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckPaymentMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.salesService.FeedbackRequest> feedback(
        io.grpc.stub.StreamObserver<com.proto.salesService.FeedbackResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getFeedbackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendOrderMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.salesService.OrderRequest,
                com.proto.salesService.OrderResponse>(
                  this, METHODID_SEND_ORDER)))
          .addMethod(
            getCheckPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.salesService.PaymentRequest,
                com.proto.salesService.PaymentResponse>(
                  this, METHODID_CHECK_PAYMENT)))
          .addMethod(
            getFeedbackMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.salesService.FeedbackRequest,
                com.proto.salesService.FeedbackResponse>(
                  this, METHODID_FEEDBACK)))
          .build();
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class SalesServiceStub extends io.grpc.stub.AbstractStub<SalesServiceStub> {
    private SalesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.salesService.OrderRequest> sendOrder(
        io.grpc.stub.StreamObserver<com.proto.salesService.OrderResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendOrderMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void checkPayment(com.proto.salesService.PaymentRequest request,
        io.grpc.stub.StreamObserver<com.proto.salesService.PaymentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.salesService.FeedbackRequest> feedback(
        io.grpc.stub.StreamObserver<com.proto.salesService.FeedbackResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFeedbackMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class SalesServiceBlockingStub extends io.grpc.stub.AbstractStub<SalesServiceBlockingStub> {
    private SalesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.salesService.PaymentResponse checkPayment(com.proto.salesService.PaymentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckPaymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Service Definition
   * </pre>
   */
  public static final class SalesServiceFutureStub extends io.grpc.stub.AbstractStub<SalesServiceFutureStub> {
    private SalesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.salesService.PaymentResponse> checkPayment(
        com.proto.salesService.PaymentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckPaymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_PAYMENT = 0;
  private static final int METHODID_SEND_ORDER = 1;
  private static final int METHODID_FEEDBACK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SalesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SalesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_PAYMENT:
          serviceImpl.checkPayment((com.proto.salesService.PaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.salesService.PaymentResponse>) responseObserver);
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
        case METHODID_SEND_ORDER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendOrder(
              (io.grpc.stub.StreamObserver<com.proto.salesService.OrderResponse>) responseObserver);
        case METHODID_FEEDBACK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.feedback(
              (io.grpc.stub.StreamObserver<com.proto.salesService.FeedbackResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SalesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SalesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.salesService.DemoSalesServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SalesService");
    }
  }

  private static final class SalesServiceFileDescriptorSupplier
      extends SalesServiceBaseDescriptorSupplier {
    SalesServiceFileDescriptorSupplier() {}
  }

  private static final class SalesServiceMethodDescriptorSupplier
      extends SalesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SalesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SalesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SalesServiceFileDescriptorSupplier())
              .addMethod(getSendOrderMethod())
              .addMethod(getCheckPaymentMethod())
              .addMethod(getFeedbackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
