package com.trp.onboarding.OMS.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import protoGenerated.Order;
import protoGenerated.OrderServiceGrpc;

import javax.annotation.PostConstruct;

/**
 * The gRPC Order service client.
 */
@Component
public class OrderServiceClient {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrderServiceClient.class);
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    /**
     * Instantiates a Managed Channel to create a blocking stub for handling server requests
     *
     * @return the order
     */
    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 9090).usePlaintext().build();
        orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(managedChannel);
    }

    /**
     * Get order by id -gRPC implementation.
     *
     * @param id the id
     * @return the order
     */
    public Order getOrderByID(String id) {
        Order order = Order.newBuilder().setId(id).build();
        Order response = orderServiceBlockingStub.getOrderByID(order);
        LOGGER.info("client sending {}", response);
        return response;
    }


}
