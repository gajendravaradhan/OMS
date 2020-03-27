package protoGenerated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * The type Order service grpc.
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.28.0)",
        comments = "Source: com/trp/onboarding/OMS/proto/OrderService.proto")
public final class OrderServiceGrpc {

    /**
     * The constant SERVICE_NAME.
     */
    public static final String SERVICE_NAME = "protoGenerated.OrderService";
    private static final int METHODID_EXECUTE_ORDER = 0;
    private static final int METHODID_GET_ORDER_BY_ID = 1;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<protoGenerated.Order,
            protoGenerated.AcknowledgeReceipt> getExecuteOrderMethod;
    private static volatile io.grpc.MethodDescriptor<protoGenerated.Order,
            protoGenerated.Order> getGetOrderByIDMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private OrderServiceGrpc() {
    }

    /**
     * Gets execute order method.
     *
     * @return the execute order method
     */
    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "executeOrder",
            requestType = protoGenerated.Order.class,
            responseType = protoGenerated.AcknowledgeReceipt.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<protoGenerated.Order,
            protoGenerated.AcknowledgeReceipt> getExecuteOrderMethod() {
        io.grpc.MethodDescriptor<protoGenerated.Order, protoGenerated.AcknowledgeReceipt> getExecuteOrderMethod;
        if ((getExecuteOrderMethod = OrderServiceGrpc.getExecuteOrderMethod) == null) {
            synchronized (OrderServiceGrpc.class) {
                if ((getExecuteOrderMethod = OrderServiceGrpc.getExecuteOrderMethod) == null) {
                    OrderServiceGrpc.getExecuteOrderMethod = getExecuteOrderMethod =
                            io.grpc.MethodDescriptor.<protoGenerated.Order, protoGenerated.AcknowledgeReceipt>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "executeOrder"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            protoGenerated.Order.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            protoGenerated.AcknowledgeReceipt.getDefaultInstance()))
                                    .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("executeOrder"))
                                    .build();
                }
            }
        }
        return getExecuteOrderMethod;
    }

    /**
     * Gets get order by id method.
     *
     * @return the get order by id method
     */
    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "getOrderByID",
            requestType = protoGenerated.Order.class,
            responseType = protoGenerated.Order.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<protoGenerated.Order,
            protoGenerated.Order> getGetOrderByIDMethod() {
        io.grpc.MethodDescriptor<protoGenerated.Order, protoGenerated.Order> getGetOrderByIDMethod;
        if ((getGetOrderByIDMethod = OrderServiceGrpc.getGetOrderByIDMethod) == null) {
            synchronized (OrderServiceGrpc.class) {
                if ((getGetOrderByIDMethod = OrderServiceGrpc.getGetOrderByIDMethod) == null) {
                    OrderServiceGrpc.getGetOrderByIDMethod = getGetOrderByIDMethod =
                            io.grpc.MethodDescriptor.<protoGenerated.Order, protoGenerated.Order>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOrderByID"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            protoGenerated.Order.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            protoGenerated.Order.getDefaultInstance()))
                                    .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("getOrderByID"))
                                    .build();
                }
            }
        }
        return getGetOrderByIDMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     *
     * @param channel the channel
     * @return the order service stub
     */
    public static OrderServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
                    @java.lang.Override
                    public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new OrderServiceStub(channel, callOptions);
                    }
                };
        return OrderServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     *
     * @param channel the channel
     * @return the order service blocking stub
     */
    public static OrderServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
                    @java.lang.Override
                    public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new OrderServiceBlockingStub(channel, callOptions);
                    }
                };
        return OrderServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     *
     * @param channel the channel
     * @return the order service future stub
     */
    public static OrderServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
                new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
                    @java.lang.Override
                    public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                        return new OrderServiceFutureStub(channel, callOptions);
                    }
                };
        return OrderServiceFutureStub.newStub(factory, channel);
    }

    /**
     * Gets service descriptor.
     *
     * @return the service descriptor
     */
    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (OrderServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
                            .addMethod(getExecuteOrderMethod())
                            .addMethod(getGetOrderByIDMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     * The type Order service impl base.
     */
    public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

        /**
         * Execute order.
         *
         * @param request          the request
         * @param responseObserver the response observer
         */
        public void executeOrder(protoGenerated.Order request,
                                 io.grpc.stub.StreamObserver<protoGenerated.AcknowledgeReceipt> responseObserver) {
            asyncUnimplementedUnaryCall(getExecuteOrderMethod(), responseObserver);
        }

        /**
         * Gets order by id.
         *
         * @param request          the request
         * @param responseObserver the response observer
         */
        public void getOrderByID(protoGenerated.Order request,
                                 io.grpc.stub.StreamObserver<protoGenerated.Order> responseObserver) {
            asyncUnimplementedUnaryCall(getGetOrderByIDMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getExecuteOrderMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            protoGenerated.Order,
                                            protoGenerated.AcknowledgeReceipt>(
                                            this, METHODID_EXECUTE_ORDER)))
                    .addMethod(
                            getGetOrderByIDMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            protoGenerated.Order,
                                            protoGenerated.Order>(
                                            this, METHODID_GET_ORDER_BY_ID)))
                    .build();
        }
    }

    /**
     * The type Order service stub.
     */
    public static final class OrderServiceStub extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
        private OrderServiceStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderServiceStub(channel, callOptions);
        }

        /**
         * Execute order.
         *
         * @param request          the request
         * @param responseObserver the response observer
         */
        public void executeOrder(protoGenerated.Order request,
                                 io.grpc.stub.StreamObserver<protoGenerated.AcknowledgeReceipt> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getExecuteOrderMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         * Gets order by id.
         *
         * @param request          the request
         * @param responseObserver the response observer
         */
        public void getOrderByID(protoGenerated.Order request,
                                 io.grpc.stub.StreamObserver<protoGenerated.Order> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getGetOrderByIDMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * The type Order service blocking stub.
     */
    public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
        private OrderServiceBlockingStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceBlockingStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderServiceBlockingStub(channel, callOptions);
        }

        /**
         * Execute order proto generated . acknowledge receipt.
         *
         * @param request the request
         * @return the proto generated . acknowledge receipt
         */
        public protoGenerated.AcknowledgeReceipt executeOrder(protoGenerated.Order request) {
            return blockingUnaryCall(
                    getChannel(), getExecuteOrderMethod(), getCallOptions(), request);
        }

        /**
         * Gets order by id.
         *
         * @param request the request
         * @return the order by id
         */
        public protoGenerated.Order getOrderByID(protoGenerated.Order request) {
            return blockingUnaryCall(
                    getChannel(), getGetOrderByIDMethod(), getCallOptions(), request);
        }
    }

    /**
     * The type Order service future stub.
     */
    public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
        private OrderServiceFutureStub(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceFutureStub build(
                io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrderServiceFutureStub(channel, callOptions);
        }

        /**
         * Execute order com . google . common . util . concurrent . listenable future.
         *
         * @param request the request
         * @return the com . google . common . util . concurrent . listenable future
         */
        public com.google.common.util.concurrent.ListenableFuture<protoGenerated.AcknowledgeReceipt> executeOrder(
                protoGenerated.Order request) {
            return futureUnaryCall(
                    getChannel().newCall(getExecuteOrderMethod(), getCallOptions()), request);
        }

        /**
         * Gets order by id.
         *
         * @param request the request
         * @return the order by id
         */
        public com.google.common.util.concurrent.ListenableFuture<protoGenerated.Order> getOrderByID(
                protoGenerated.Order request) {
            return futureUnaryCall(
                    getChannel().newCall(getGetOrderByIDMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final OrderServiceImplBase serviceImpl;
        private final int methodId;

        /**
         * Instantiates a new Method handlers.
         *
         * @param serviceImpl the service
         * @param methodId    the method id
         */
        MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_EXECUTE_ORDER:
                    serviceImpl.executeOrder((protoGenerated.Order) request,
                            (io.grpc.stub.StreamObserver<protoGenerated.AcknowledgeReceipt>) responseObserver);
                    break;
                case METHODID_GET_ORDER_BY_ID:
                    serviceImpl.getOrderByID((protoGenerated.Order) request,
                            (io.grpc.stub.StreamObserver<protoGenerated.Order>) responseObserver);
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

    private static abstract class OrderServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        /**
         * Instantiates a new Order service base descriptor supplier.
         */
        OrderServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return protoGenerated.OrderServiceOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("OrderService");
        }
    }

    private static final class OrderServiceFileDescriptorSupplier
            extends OrderServiceBaseDescriptorSupplier {
        /**
         * Instantiates a new Order service file descriptor supplier.
         */
        OrderServiceFileDescriptorSupplier() {
        }
    }

    private static final class OrderServiceMethodDescriptorSupplier
            extends OrderServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        /**
         * Instantiates a new Order service method descriptor supplier.
         *
         * @param methodName the method name
         */
        OrderServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
