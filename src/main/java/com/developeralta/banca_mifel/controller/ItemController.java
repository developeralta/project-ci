package com.developeralta.banca_mifel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developeralta.banca_mifel.mapper.ItemMapper;
import com.developeralta.banca_mifel.model.dto.ItemRequest;
import com.developeralta.banca_mifel.model.entity.Item;
import com.developeralta.banca_mifel.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = { "http://localhost:4200" }, originPatterns = { "*" })
@RestController
@RequestMapping("/api/items")
@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Items", description = "CRUD de items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    @Operation(summary = "Obtener lista de items", description = "Retorna todos los items")
    public List<Item> list() {
        return itemService.findAll();
    }

    @GetMapping("/{name}")
    @Operation(summary = "Obtener lista de items por nombre", description = "Retorna todos los items con nombre específico")
    public List<Item> listByName(@PathVariable String name) {
        if (name == null || name.isEmpty()) {
            return itemService.findAll();
        }

        return itemService.findAllByName(name);
    }

    @PostMapping
    @Operation(summary = "Agrega un item", description = "Agrega un item a la lista")
    public ResponseEntity<?> create(@RequestBody ItemRequest itemRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(mapErrors(result.getFieldErrors()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(ItemMapper.toEntity(itemRequest)));
    }

    private Map<String, String> mapErrors(List<FieldError> fields) {
        Map<String, String> errors = new HashMap<>();
        fields.forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return errors;
    }
}
