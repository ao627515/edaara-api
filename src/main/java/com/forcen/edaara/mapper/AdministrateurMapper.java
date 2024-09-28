package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.AdministrateurRequestDTO;
import com.forcen.edaara.dto.response.AdministrateurResponseDTO;
import com.forcen.edaara.model.Administrateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministrateurMapper {

    // Mapper pour convertir un Administrateur en AdministrateurResponseDTO
    AdministrateurResponseDTO toDto(Administrateur administrateur);
    List<AdministrateurResponseDTO> toDtoList(List<Administrateur> administrateurList);

    Administrateur toEntity(AdministrateurRequestDTO dto);
    Administrateur toEntity(Administrateur administrateur);

    // Mapper pour convertir un AdministrateurRequestDTO en Administrateur
    Administrateur toEntityFromRequestDTO(AdministrateurRequestDTO dto);
}


