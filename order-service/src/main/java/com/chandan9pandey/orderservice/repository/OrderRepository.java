package com.chandan9pandey.orderservice.repository;

import com.chandan9pandey.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
