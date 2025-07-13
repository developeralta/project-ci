package com.developeralta.banca_mifel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developeralta.banca_mifel.model.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByNombreContainingIgnoreCase(String nombre);

}
