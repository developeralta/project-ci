package com.developeralta.example_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developeralta.example_project.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
