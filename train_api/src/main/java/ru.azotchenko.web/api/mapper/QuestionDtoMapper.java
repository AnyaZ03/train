package ru.azotchenko.web.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.domain.model.Project;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.azotchenko.web.api.dto.OpenQuestionCardDto;
import ru.azotchenko.web.api.dto.ProjectDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDtoMapper {
    OpenQuestionCard mapToModel(OpenQuestionCardDto entity);

    OpenQuestionCardDto mapToDto(OpenQuestionCard task);

    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardDto> entities);

    List<OpenQuestionCardDto> mapToDto(List<OpenQuestionCard> tasks);

    Project mapToModel(ProjectDto entity);

    ProjectDto mapToDto(Project project);

    List<Project> mapProjectsToModel(List<ProjectDto> entities);

    List<ProjectDto> mapProjectsToDto(List<Project> projects);
}