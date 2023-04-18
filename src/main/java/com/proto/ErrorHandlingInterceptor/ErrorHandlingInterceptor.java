package com.proto.ErrorHandlingInterceptor;



import io.grpc.*;

public class ErrorHandlingInterceptor implements ClientInterceptor {
    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
        ClientCall<ReqT, RespT> call = next.newCall(method, callOptions);
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(call) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(responseListener) {
                    @Override
                    public void onClose(Status status, Metadata trailers) {
                        if (status.isOk()) {
                            super.onClose(status, trailers);
                        } else {
                            System.out.println("An error occurred while communicating with the server: " + status.getDescription());
                            super.onClose(status, trailers);
                        }
                    }
                }, headers);
            }
        };
    }
}
