package com.spring.springApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springApi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByName(String name);
}
