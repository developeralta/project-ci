package com.developeralta.banca_mifel.service;

import java.util.List;

import com.developeralta.banca_mifel.model.entity.Item;

public interface ItemService {

    public List<Item> findAll();

    public List<Item> findAllByName(String name);

    public Item create(Item item);

}
