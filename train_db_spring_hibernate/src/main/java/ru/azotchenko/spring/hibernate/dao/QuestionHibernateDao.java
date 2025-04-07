package ru.azotchenko.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.azotchenko.domain.model.OpenQuestionCard;
import ru.azotchenko.domain.repo.QuestionRepository;
import ru.azotchenko.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.azotchenko.spring.hibernate.mapper.QuestionMapper;
import ru.azotchenko.spring.hibernate.repo.QuestionCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class QuestionHibernateDao implements QuestionRepository {

    private static final Logger logger = LogManager.getLogger(QuestionHibernateDao.class);

    private final QuestionMapper mapper;
    private final QuestionCrudRepository repository;
    @PersistenceContext
    private EntityManager entityManager;
    public QuestionHibernateDao(QuestionMapper mapper, QuestionCrudRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public void save(OpenQuestionCard card) {
        OpenQuestionCardEntity entity = mapper.mapToEntity(card);
        if (findById(entity.getId()).isPresent()) {
            entityManager.merge(entity);
        } else {
            entity.setId(null);
            entityManager.persist(entity);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<OpenQuestionCard> findAll() {
        logger.debug("Выбираем всех");
        List<OpenQuestionCardEntity> questionEntities = repository.findAll();
        return mapper.mapToModel(questionEntities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OpenQuestionCard> findById(Long id) {
        Optional<OpenQuestionCardEntity> entity = repository.findById(id);
        return entity.map(mapper::mapToModel);
    }
    @Override
    public void add(OpenQuestionCard openQuestionCard) {
        OpenQuestionCardEntity entity = mapper.mapToEntity(openQuestionCard);
        repository.save(entity);
    }

    @Override
    public void update(OpenQuestionCard openQuestionCard) {
        OpenQuestionCardEntity entity = mapper.mapToEntity(openQuestionCard);
        repository.save(entity);
    }

    @Override
    public void remove(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
