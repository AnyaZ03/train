package ru.azotchenko.spring.hibernate.mapper;

import org.mapstruct.Mapper;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    OpenQuestionCard mapToModel(OpenQuestionCardEntity entity);
    OpenQuestionCardEntity mapToEntity(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardEntity> entities);
    List<OpenQuestionCardEntity> mapToEntity(List<OpenQuestionCard> questions);
}