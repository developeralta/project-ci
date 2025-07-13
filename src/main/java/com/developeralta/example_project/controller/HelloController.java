package com.developeralta.example_project.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = { "http://localhost:4200" }, originPatterns = { "*" })
@RestController
@RequestMapping("/hello-wold")
@Tag(name = "Public", description = "Hello world!")
public class HelloController {

    @GetMapping
    @Operation(summary = "Mostrar mensaje de bienvenida", description = "Retorna un mensaje de bienvenida")
    public List<Item> list() {
        return "Hola mundo by developeralta e Integración continua...";
    }

}