package com.forcen.edaara.mapper;
import com.forcen.edaara.dto.ParcoursRequestDTO;
import com.forcen.edaara.dto.response.ParcourResponseDTO;
import com.forcen.edaara.model.Parcours;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParcoursMapper {
    ParcourResponseDTO toDto(Parcours parcours);
    List<ParcourResponseDTO> toDtoList(List<Parcours> parcoursList);
    Parcours toEntity(ParcoursRequestDTO parcoursRequestDTO);
}
