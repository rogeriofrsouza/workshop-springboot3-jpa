package com.rogeriofrsouza.course.services;

import com.rogeriofrsouza.course.entities.Product;
import com.rogeriofrsouza.course.exceptions.ResourceNotFoundException;
import com.rogeriofrsouza.course.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
