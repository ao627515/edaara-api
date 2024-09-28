package com.forcen.edaara.mapper;

import com.forcen.edaara.dto.EvaluationRequestDTO;
import com.forcen.edaara.dto.response.EvaluationResponseDTO;
import com.forcen.edaara.model.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluationMapper {
    @Mapping(source = "etudiant.idUtilisateur", target = "etudiant_id")
    EvaluationResponseDTO toResponseDto(Evaluation evaluation);
    List<EvaluationResponseDTO> toResponseDtoList(List<Evaluation> evaluationList);
    Evaluation toModel(EvaluationRequestDTO evaluationRequestDTO);
    Evaluation toEntity(Evaluation evaluation);
}
