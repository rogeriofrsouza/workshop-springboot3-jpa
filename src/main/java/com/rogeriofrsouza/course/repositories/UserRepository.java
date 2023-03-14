package com.rogeriofrsouza.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rogeriofrsouza.course.entities.User;

/*
 * Spring Data JPA possui uma implementação padrão desta interface
 * Não necessita do @Repository pois JpaRepository já está registrado como componente do Spring
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
