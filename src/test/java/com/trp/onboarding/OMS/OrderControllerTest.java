package com.trp.onboarding.OMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trp.onboarding.OMS.application.controllers.OrderController;
import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.business.service.OrderService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class OrderControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Mock
    OrderService orderService;

    Order orderExpected;

    @Autowired
    ObjectMapper objectMapper;

    @InjectMocks
    OrderController orderController;

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void saveOrder() throws Exception {
        Order order = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        when(orderService.saveOrder(any(Order.class))).thenReturn(order);
        Order result = orderController.saveOrder(order);
        assertEquals("MOCK", result.getTicker());
    }

    @Test
    public void getAllOrders() {
        List<Order> listOrder = new ArrayList<>();
        Order order = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        listOrder.add(order);
        when(orderService.getAllOrders()).thenReturn(listOrder);
        List<Order> resultList = orderController.getAllOrders();
        assertEquals("MOCK", resultList.get(0).getTicker());
    }

    @Test
    public void getOrderByID() {
        Order order = new Order(UUID.fromString("7661f136-77e4-4d92-b9bb-f0aa1723a812"), "test2@test.com", LocalDateTime.now(), "MOCK", "S", 23.05, 45);
        when(orderService.getOrderByID(any(UUID.class))).thenReturn(order);
        Order result = orderController.getOrderByID(order.getId());
        assertAll("content check", () -> assertEquals("MOCK", result.getTicker()),
                () -> assertEquals("test2@test.com", result.getUserEmail()));
    }

    @Test
    public void testGetAllRequestResponse() throws Exception {
        Order order = new Order("test2@test.com", "MOCK", "S", 23.05, 45);
        //String orderString = "{\"userEmail\": \"a@b.com\",\"ticker\": \"AMZN.45345252\",\"direction\": \"B\",\"price\": 10.02,\"quantity\": 12.25}";
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(get("/api/v1/order/getAll"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        List<Order> resultList = Arrays.asList(objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Order[].class));
        assertEquals(200, status);
        assertTrue(resultList.size() > 0);
    }

    @Test
    public void testSaveRequestResponse() throws Exception {
        Order order = new Order("test2@test.com", "MOCK", "S", 23.05, 45);
        Order orderExpected = new Order(UUID.randomUUID(), "testMock@test.com", LocalDateTime.now(), "TSTMK", "B", 0.007, 32767);
        when(orderService.saveOrder(any(Order.class))).thenReturn(orderExpected);
        //String orderString = "{\"userEmail\": \"a@b.com\",\"ticker\": \"AMZN.45345252\",\"direction\": \"B\",\"price\": 10.02,\"quantity\": 12.25}";
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String content = mapToJson(order);
        MvcResult mvcResult = mvc.perform(post("/api/v1/order/saveOrder")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(content))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}