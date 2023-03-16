package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
