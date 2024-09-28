package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.FormateurRequestDTO;
import com.forcen.edaara.dto.response.FormateurResponseDTO;
import com.forcen.edaara.model.Formateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormateurMapper {
    FormateurResponseDTO toDto(Formateur formateur);
    Formateur toEntity(FormateurRequestDTO dto);
}
