package ru.azotchenko.domain.model;

public class OpenQuestionCard {
    private final  Long id;
    private final String question;

    private final String expectedAnswer;

    public OpenQuestionCard(Long id, String question, String expectedAnswer) {

        if (question == null || question.trim().isEmpty()){
            throw new IllegalArgumentException("Значение question не должно быть пустым или null");
        }

        if (expectedAnswer == null || expectedAnswer.trim().isEmpty()){
            throw new IllegalArgumentException("Значение expectedAnswer не должно быть пустым или null");
        }

        this.question = question;
        this.expectedAnswer = expectedAnswer;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public boolean checkAnswer(String userAnswer) {
        return expectedAnswer.equals(userAnswer);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OpenQuestionCard{" +
                "question='" + question + '\'' +
                ", expectedAnswer='" + expectedAnswer + '\'' +
                '}';
    }
}