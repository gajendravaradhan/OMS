package com.trp.onboarding.OMS.infrastructure;

import com.trp.onboarding.OMS.business.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The interface Order repository.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
