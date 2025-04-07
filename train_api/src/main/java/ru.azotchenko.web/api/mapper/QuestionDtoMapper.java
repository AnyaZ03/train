package ru.azotchenko.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.azotchenko.web.api.dto.OpenQuestionCardDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDtoMapper {
    OpenQuestionCard mapToModel(OpenQuestionCardDto entity);
    OpenQuestionCardDto mapToDto(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardDto> entities);
    List<OpenQuestionCardDto> mapToDto(List<OpenQuestionCard> questions);
}
