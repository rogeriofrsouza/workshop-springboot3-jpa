package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
