package com.trp.onboarding.OMS;

import com.trp.onboarding.OMS.business.domain.Order;
import com.trp.onboarding.OMS.infrastructure.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository repository;

    @Test
    public void testFindByID() {
        Order order = new Order("test@gmail.com", LocalDateTime.now(), "BBB", "S", 23.43, 10);
        entityManager.persist(order);

        Order result = repository.findById(order.getId()).orElse(null);
        assertEquals("test@gmail.com", Objects.requireNonNull(result).getUserEmail());

        assertThat(order.getTicker()).isEqualTo("BBB");

    }

    @Test
    public void testFindAll() {
        Order order_one = new Order("test1@gmail.com", LocalDateTime.now(), "BBB", "S", 23.43, 10);
        Order order_two = new Order("test2@gmail.com", LocalDateTime.now(), "AAA", "B", 20.43, 15);
        entityManager.persist(order_one);
        entityManager.persist(order_two);
        List<Order> result = repository.findAll();


        assertThat(result.get(0).getTicker()).isEqualTo("BBB");
        assertEquals(2, result.size());

        assertThat(result).extracting(Order::getDirection).contains("B");

    }

}