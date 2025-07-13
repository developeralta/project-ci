package com.developeralta.example_project.service;

import java.util.List;

import com.developeralta.example_project.model.entity.Item;

public interface ItemService {

    public List<Item> findAll();

    public List<Item> findAllByName(String name);

    public Item create(Item item);

}
