package com.trp.onboarding.OMS.business.service;

import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.infrastructure.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * The type Order service.
 */
@Service
public class OrderService {
    /**
     * The Order repository.
     */
    @Autowired
    OrderRepository orderRepository;

    /**
     * Get order by id - JPA Implementation
     *
     * @param id the id
     * @return the matching order
     */
    public Order getOrderByID(UUID id) {
        return orderRepository.findById(id).get();
    }

    /**
     * Get all orders - JPA implementation.
     *
     * @return the list of orders
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Save order to database - JPA implementation.
     *
     * @param order the order
     * @return the order
     */
    public Order saveOrder(Order order) {
        order.setOrderTime(LocalDateTime.now());
        return orderRepository.save(order);
    }
}
