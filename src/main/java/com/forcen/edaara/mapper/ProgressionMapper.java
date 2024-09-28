package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.ProgressionRequestDTO;
import com.forcen.edaara.dto.response.ProgressionResponseDTO;
import com.forcen.edaara.model.Progression;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgressionMapper {

  @Mappings({
          @Mapping(source = "etudiant.idUtilisateur", target = "etudiant_id"),
          @Mapping(source = "cours.idCours", target = "cours_id")
  })
  ProgressionResponseDTO toResponseDto(Progression progression);
  List<ProgressionResponseDTO> toResponseDtoList(List<Progression> progressionList);
  Progression toModel(ProgressionRequestDTO progressionRequestDTO);
  Progression toEntity(Progression progression);
}
