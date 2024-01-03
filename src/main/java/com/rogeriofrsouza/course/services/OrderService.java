package com.rogeriofrsouza.course.services;

import com.rogeriofrsouza.course.entities.Order;
import com.rogeriofrsouza.course.exceptions.ResourceNotFoundException;
import com.rogeriofrsouza.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
