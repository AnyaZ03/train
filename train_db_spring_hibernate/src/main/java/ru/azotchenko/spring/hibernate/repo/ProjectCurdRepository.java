package ru.azotchenko.spring.hibernate.repo;

import org.springframework.data.repository.CrudRepository;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.azotchenko.spring.hibernate.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectCurdRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findAll();
    Optional<ProjectEntity> findById(Long id);
}

