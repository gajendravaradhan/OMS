package com.trp.onboarding.OMS;

import com.trp.onboarding.OMS.application.controllers.OrderController;
import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.business.service.OrderService;
import com.trp.onboarding.OMS.infrastructure.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DirtiesContext
class OrderServiceTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @MockBean
    private OrderRepository repository;

    @BeforeEach
    void setUp() {
        LOGGER.info("Order Service test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveOrderTest() {
        Order order = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        when(repository.save(order)).thenReturn(order);
        String orderID = repository.save(order).getId().toString();
        assertEquals("7661f136-77e4-4d92-b9bb-f0aa1723a812", orderID);
    }

    @Test
    void getAllOrdersTest() {
        when(repository.findAll()).thenReturn(Stream.of(new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test1@test.com", LocalDateTime.now(), "TEST", "B", 23.05, 45),
                new Order(UUID.fromString("648c0619-07b0-42c3-b730-ad736ca77444"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45)
                ).collect(Collectors.toList())
        );
        assertAll("Size and Content", () -> assertEquals(2, orderService.getAllOrders().size()),
                () -> assertEquals("MOCK", orderService.getAllOrders().get(1).getTicker())
        );
    }

    @Test
    void getOrderByIDTest() {
        UUID id = UUID.randomUUID();
        when(repository.findById(id)).thenReturn(Optional.of(new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45)));
        assertAll("Size and Content",
                () -> assertNotNull(orderService.getOrderByID(id)),
                () -> assertEquals("test2@test.com", orderService.getOrderByID(id).getUserEmail()),
                () -> assertEquals("MOCK", orderService.getOrderByID(id).getTicker())
        );
    }
}