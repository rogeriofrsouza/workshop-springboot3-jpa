package com.rogeriofrsouza.course.services;

import com.rogeriofrsouza.course.entities.Category;
import com.rogeriofrsouza.course.exceptions.ResourceNotFoundException;
import com.rogeriofrsouza.course.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
