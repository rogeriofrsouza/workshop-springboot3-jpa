package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
