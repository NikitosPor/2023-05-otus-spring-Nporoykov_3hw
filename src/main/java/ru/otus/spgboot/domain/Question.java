package ru.otus.spgboot.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;

    private List<Answer> listOfAnswers = new ArrayList<>();

    public Question(String question, List<Answer> listOfAnswers) {
        this.question = question;
        this.listOfAnswers = listOfAnswers;
    }

    public String getQuestion() {
        return this.question;
    }

    public List<Answer> getListOfAnswers() {
        return this.listOfAnswers;
    }
}
