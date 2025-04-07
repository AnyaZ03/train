package ru.azotchenko.spring.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class OpenQuestionCardEntity {


//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "code")
//    private Long code;
    @Id
    @Column
    private Long id;
    @Column
    private String question;

    @Column
    private String expectedAnswer;

//    public Long getCode() {
//        return code;
//    }

//    public void setCode(Long code) {
//        this.code = code;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }
}
