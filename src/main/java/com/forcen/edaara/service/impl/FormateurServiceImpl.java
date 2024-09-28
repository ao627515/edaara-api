package com.forcen.edaara.service.impl;


import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.enums.Role;
import com.forcen.edaara.mapper.FormateurMapper;
import com.forcen.edaara.model.Formateur;
import com.forcen.edaara.repository.FormateurRepository;
import com.forcen.edaara.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final FormateurMapper formateurMapper;

    private static final String FORMATEUR_NOT_FOUND = "Formateur non trouvé";
    private static final String COURS_NOT_FOUND = "Cours non trouvé";


    @Override
    public FormateurResponseDTO ajouterFormateur(FormateurRequestDTO formateurRequestDTO) {
        Formateur formateur = formateurMapper.toEntity(formateurRequestDTO);
        formateur.setRole(Role.FORMATEUR);
        Formateur savedFormateur = formateurRepository.save(formateur);
        return formateurMapper.toDto(savedFormateur);
    }
}
