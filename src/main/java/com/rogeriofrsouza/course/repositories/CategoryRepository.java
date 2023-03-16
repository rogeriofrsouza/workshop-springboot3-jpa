package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
