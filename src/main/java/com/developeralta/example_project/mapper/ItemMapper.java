package com.developeralta.example_project.mapper;

import com.developeralta.example_project.model.dto.ItemRequest;
import com.developeralta.example_project.model.entity.Item;

public class ItemMapper {
    public static Item toEntity(ItemRequest itemRequest) {
        Item item = new Item();
        item.setNombre(itemRequest.getNombre());
        item.setDescrip(itemRequest.getDescrip());
        item.setCantidad(itemRequest.getCantidad());

        return item;
    }
}
