package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.EtudiantRequestDTO;
import com.forcen.edaara.dto.response.EtudiantResponseDTO;
import com.forcen.edaara.model.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    @Mapping(source = "parcours.idParcours", target = "parcoursId")
    EtudiantResponseDTO toDto(Etudiant etudiant);
    EtudiantRequestDTO toRequestDto(Etudiant etudiant);
    List<EtudiantResponseDTO> toDtoList(List<Etudiant> etudiantList);
    Etudiant toEntity(EtudiantRequestDTO etudiantRequestDTO);
}
