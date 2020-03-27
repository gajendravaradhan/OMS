package com.trp.onboarding.OMS.business.service;

//import com.trp.onboarding.OMS.dao.IOrdersDAO;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import protoGenerated.Order;
import protoGenerated.OrderServiceGrpc;

import java.util.UUID;

/**
 * The grpc server implementation of Order service.
 */
@GrpcService
public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderService orderService;

    /**
     * Get order by id - gRPC Implementation
     *
     * @param request          the Order request from a gRPC client
     * @param responseObserver The Stream observer response of the gRPC server
     * @return the matching order
     */
    @Override
    public void getOrderByID(Order request, StreamObserver<Order> responseObserver) {
        LOGGER.info("server received {}", request);
        UUID id = UUID.fromString(request.getId());
        com.trp.onboarding.OMS.business.domain.Order order = orderService.getOrderByID(id);
        Order protoOrder = Order.newBuilder()
                .setTicker(order.getTicker())
                .setPrice(order.getPrice())
                .setQuantity(order.getQuantity())
                .setDirection(order.getDirection())
                .setUserEmail(order.getUserEmail()).build();
        LOGGER.info("Server responds with:\n {}", protoOrder);
        responseObserver.onNext(protoOrder);
        responseObserver.onCompleted();

    }
}
