package com.trp.onboarding.OMS;

import com.trp.onboarding.OMS.client.OrderServiceClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import protoGenerated.Order;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
class OrderServiceClientTest {


    @Autowired
    private OrderServiceClient orderServiceClient;

    @Test
    public void getOrderByID() {
        Order order = orderServiceClient.getOrderByID("c57875a0-30af-408c-9418-6998ff68c02f");
        assertThat(order.getTicker()).isEqualTo("AAA");
    }

    @AfterEach
    void tearDown() {

    }
}