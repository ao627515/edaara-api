package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.model.Formateur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormateurMapper {
    Formateur toEntity(FormateurRequestDTO formateurRequestDTO);

    FormateurResponseDTO toResponseDTO(Formateur formateur);

    void updateFormateurFromDTO(FormateurRequestDTO formateurRequestDTO, @MappingTarget Formateur formateur);
}
