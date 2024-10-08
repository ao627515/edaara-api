package com.forcen.edaara.service.impl;


import com.forcen.edaara.Exception.EntityNotFoundException;
import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.enums.Role;
import com.forcen.edaara.mapper.FormateurMapper;
import com.forcen.edaara.model.Formateur;
import com.forcen.edaara.repository.FormateurRepository;
import com.forcen.edaara.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final FormateurMapper formateurMapper;

    @Override
    public FormateurResponseDTO ajouterFormateur(FormateurRequestDTO formateurRequestDTO) {
        Formateur formateur = formateurMapper.toEntity(formateurRequestDTO);
        formateur.setRole(Role.FORMATEUR);
        Formateur formateurEnregistre = formateurRepository.save(formateur);
        return formateurMapper.toResponseDTO(formateurEnregistre);
    }

    @Override
    public FormateurResponseDTO modifierFormateur(Long id, FormateurRequestDTO formateurRequestDTO) {
    Formateur formateur =
        formateurRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Formateur non trouvé avec l'ID: " + id));

        formateurMapper.updateFormateurFromDTO(formateurRequestDTO, formateur);
        Formateur formateurModifie = formateurRepository.save(formateur);
        return formateurMapper.toResponseDTO(formateurModifie);
    }

    @Override
    public void supprimerFormateur(Long id) {
        if (!formateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Formateur non trouvé avec l'ID: " + id);
        }
        formateurRepository.deleteById(id);
    }

    @Override
    public FormateurResponseDTO obtenirFormateurParId(Long id) {
        Formateur formateur = formateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formateur non trouvé avec l'ID: " + id));
        return formateurMapper.toResponseDTO(formateur);
    }

    @Override
    public List<FormateurResponseDTO> obtenirTousLesFormateurs() {
        List<Formateur> formateurs = formateurRepository.findAll();
        return formateurs.stream()
                .map(formateurMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}