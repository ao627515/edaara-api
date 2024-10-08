package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.CoursRequestDTO;
import com.forcen.edaara.dto.response.CoursResponseDTO;
import com.forcen.edaara.model.Cours;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CoursMapper {
@Mapping(source = "cours.formateur.idUtilisateur", target = "idFormateur")
    CoursResponseDTO toDto(Cours cours);

    Cours toEntity(CoursRequestDTO dto);
}