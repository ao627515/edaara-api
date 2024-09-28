package com.forcen.edaara.service;

import com.forcen.edaara.dto.ProgressionRequestDTO;
import com.forcen.edaara.dto.response.ProgressionResponseDTO;
import com.forcen.edaara.model.Progression;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgressionService {
    List<ProgressionResponseDTO> getAllProgressions();
    ProgressionResponseDTO getProgressionById(Long id);
    ProgressionResponseDTO createProgression(ProgressionRequestDTO requestDTO);
    ProgressionResponseDTO updateProgression(Long id, ProgressionRequestDTO requestDTO);
    Void deleteProgression(Long id);
}
