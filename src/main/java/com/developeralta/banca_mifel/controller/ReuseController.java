package com.developeralta.banca_mifel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developeralta.banca_mifel.service.ExternalAPIService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = { "http://localhost:4200" }, originPatterns = { "*" })
@RestController
@RequestMapping("/api/reuse")
@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Reutilizar API", description = "Reutilizar API")
public class ReuseController {

    private final String uri = "https://pokeapi.co/api/v2/pokemon/ditto";

    @Autowired
    private ExternalAPIService externalAPIService;

    @GetMapping
    @Operation(summary = "Reutilizar una API", description = "Devuelve el resultado del API en formato JSON")
    public String reuseAPI() {
        return externalAPIService.methodGET(uri);
    }

}
