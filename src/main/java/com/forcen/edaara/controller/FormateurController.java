package com.forcen.edaara.controller;

import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formateurs")
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService formateurService;

    @PostMapping
    public ResponseEntity<FormateurResponseDTO> ajouterFormateur(@RequestBody FormateurRequestDTO formateurRequestDTO) {
        FormateurResponseDTO nouveauFormateur = formateurService.ajouterFormateur(formateurRequestDTO);
        return new ResponseEntity<>(nouveauFormateur, HttpStatus.CREATED);
    }
}
