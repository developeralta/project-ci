package com.developeralta.example_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developeralta.example_project.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNombreContainingIgnoreCase(String nombre);

}
