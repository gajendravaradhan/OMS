package com.trp.onboarding.OMS.server;

import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.business.service.OrderService;
import com.trp.onboarding.OMS.business.service.OrderServiceImpl;
import io.grpc.testing.GrpcServerRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import protoGenerated.OrderServiceGrpc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class OrderServiceImplTest {

    /**
     * This creates and starts an in-process server, and creates a client with an in-process channel.
     * When the test is done, it also shuts down the in-process client and server.
     */
    @Rule
    public final GrpcServerRule grpcServerRule = new GrpcServerRule().directExecutor();
    @Mock
    OrderService orderService;
    @Autowired
    OrderServiceImpl orderServiceImpl;
    Order orderExpected;

    @Before
    public void setUp() throws Exception {
        orderExpected = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        when(orderService.getOrderByID(any(UUID.class))).thenReturn(orderExpected);
    }

    @Test
    @Disabled
    public void getOrderByID() {
        Order order = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a817"), "testActual@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        when(orderService.getOrderByID(any(UUID.class))).thenReturn(orderExpected);

    }

    /**
     * To test the server, make calls with a real stub using the in-process channel, and verify
     * behaviors or state changes from the client side.
     */
    @Test
    public void getOrderById() throws Exception {
        // Add the service to the in-process server.
        grpcServerRule.getServiceRegistry().addService(new OrderServiceImpl());

        OrderServiceGrpc.OrderServiceBlockingStub blockingStub = OrderServiceGrpc.newBlockingStub(grpcServerRule.getChannel());
        when(orderService.getOrderByID(any(UUID.class))).thenReturn(orderExpected);
        protoGenerated.Order order = blockingStub.getOrderByID(protoGenerated.Order.newBuilder().setId(orderExpected.getId().toString()).build());

        assertEquals("test2@test.com", order.getUserEmail());
    }

}