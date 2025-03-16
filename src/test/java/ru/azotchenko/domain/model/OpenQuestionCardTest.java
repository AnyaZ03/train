package ru.azotchenko.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OpenQuestionCardTest {

    private static final String CARD_QUESTION = "Что представляет собой интерфейс в Java?";

    private static final String CARD_EXPECTED_ANSWER = "Абстрактный тип, определяющий набор методов, которые должны быть реализованы классом.";

    private OpenQuestionCard openQuestionCard;

    @BeforeEach
    void setUp() {
        openQuestionCard = new OpenQuestionCard(CARD_QUESTION, CARD_EXPECTED_ANSWER);
    }

    @Test
    @DisplayName("Создание OpenQuestionCard с валидными параметрами выполняется успешно")
    void given_validQuestion_when_creatingOpenQuestionCard_then_instanceIsCreated() {
        Assertions.assertEquals(CARD_QUESTION, openQuestionCard.getQuestion());
    }

    @Test
    @DisplayName("Попытка создать OpenQuestionCard с question равным null вызывает исключение")
    void given_nullQuestion_when_creatingOpenQuestionCard_then_exceptionIsThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(null, CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("Попытка создать OpenQuestionCard с ожидаемым ответом равным null вызывает исключение")
    void given_nullExpectedAnswer_when_creatingOpenQuestionCard_then_exceptionIsThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(CARD_QUESTION, null));
    }

    @Test
    @DisplayName("Попытка создать OpenQuestionCard с пустым вопросом вызывает исключение")
    void given_emptyQuestion_when_creatingOpenQuestionCard_then_exceptionIsThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard("", CARD_EXPECTED_ANSWER));
    }

    @Test
    @DisplayName("Попытка создать OpenQuestionCard с пустым ожидаемым ответом вызывает исключение")
    void given_emptyExpectedAnswer_when_creatingOpenQuestionCard_then_exceptionIsThrown() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new OpenQuestionCard(CARD_QUESTION, ""));
    }

    @Test
    @DisplayName("Метод checkAnswer() корректно проверяет введённый ответ")
    void given_validAnswer_when_checkingAnswer_then_verificationIsCorrect() {
        String incorrectAnswer = "Некорректный ответ";
        Assertions.assertTrue(openQuestionCard.checkAnswer(CARD_EXPECTED_ANSWER));
        Assertions.assertFalse(openQuestionCard.checkAnswer(incorrectAnswer));
    }
}