package com.developeralta.banca_mifel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developeralta.banca_mifel.model.entity.Item;
import com.developeralta.banca_mifel.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllByName(String name) {
        return itemRepository.findByNombreContainingIgnoreCase(name);
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

}
