package ru.azotchenko.spring.hibernate.mapper;

import org.mapstruct.Mapper;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.domain.model.Project;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.azotchenko.spring.hibernate.entity.ProjectEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    OpenQuestionCard mapToModel(OpenQuestionCardEntity entity);
    OpenQuestionCardEntity mapToEntity(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardEntity> entities);
    List<OpenQuestionCardEntity> mapToEntity(List<OpenQuestionCard> questions);
    Project mapToModel(ProjectEntity entity);
    ProjectEntity mapToEntity(Project question);
    List<Project> mapProjectToModel(List<ProjectEntity> entities);
    List<ProjectEntity> mapProjectToEntity(List<Project> questions);
}