package com.developeralta.banca_mifel.controller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developeralta.banca_mifel.model.dto.EncodeRequest;
import com.developeralta.banca_mifel.service.EncodeTextService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = { "http://localhost:4200" }, originPatterns = { "*" })
@RestController
@RequestMapping("/api/encode")
@SecurityRequirement(name = "BearerAuth")
@Tag(name = "Encode", description = "Codificar una cadena")
public class EncodeController {

    @Autowired
    private EncodeTextService encodeTextService;

    @PostMapping
    @Operation(summary = "Codificar una cadena", description = "Regresa una cadena codificada")
    public String encode(@RequestBody EncodeRequest encodeRequest) throws InvalidKeyException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return encodeTextService.encodeAESC(encodeRequest.getText());
    }
}
