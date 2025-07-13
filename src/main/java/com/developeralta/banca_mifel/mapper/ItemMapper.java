package com.developeralta.banca_mifel.mapper;

import com.developeralta.banca_mifel.model.dto.ItemRequest;
import com.developeralta.banca_mifel.model.entity.Item;

public class ItemMapper {
    public static Item toEntity(ItemRequest itemRequest) {
        Item item = new Item();
        item.setNombre(itemRequest.getNombre());
        item.setDescrip(itemRequest.getDescrip());
        item.setCantidad(itemRequest.getCantidad());

        return item;
    }
}
