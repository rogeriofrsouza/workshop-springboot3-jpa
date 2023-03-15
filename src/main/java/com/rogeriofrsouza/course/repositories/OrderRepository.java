package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
