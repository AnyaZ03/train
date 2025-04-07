package ru.azotchenko.domain.repo;

import java.util.List;
import ru.azotchenko.domain.model.OpenQuestionCard;

import java.util.Optional;

public interface QuestionRepository {
    List<OpenQuestionCard> findAll();
    Optional<OpenQuestionCard> findById(Long id);
    void add(OpenQuestionCard openQuestionCard);
    void update(OpenQuestionCard openQuestionCard);
    void remove(Long id);
}
