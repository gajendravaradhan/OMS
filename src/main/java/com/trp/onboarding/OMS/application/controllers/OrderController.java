package com.trp.onboarding.OMS.application.controllers;

import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.business.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * The type Order controller.
 */
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderService the order service
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        LOGGER.info("Order controllers instantiated");
    }

    /**
     * Save order resource.
     *
     * @param order the order
     * @return the order
     */
    @PostMapping(path = "/saveOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Order saveOrder(@Valid @NonNull @RequestBody Order order) {
        Order result = orderService.saveOrder(order);
        LOGGER.info("Order executed Successfully");
        return result;
    }

    /**
     * Get all orders resource.
     *
     * @return the list of orders
     */
    @GetMapping(path = "/getAll")
    public List<Order> getAllOrders() {
        LOGGER.info("Orders being retrieved");
        return orderService.getAllOrders();
    }

    /**
     * Gets order by id.
     *
     * @param id the id
     * @return the order by id
     */
    @GetMapping(path = "/get/{id}")
    public Order getOrderByID(@PathVariable("id") UUID id) {
        try {
            return orderService.getOrderByID(id);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Unable to find a record with id" + id);
        }

    }

}
