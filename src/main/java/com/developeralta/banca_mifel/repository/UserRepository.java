package com.developeralta.banca_mifel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developeralta.banca_mifel.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
