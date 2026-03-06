package com.employee.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	
}
