package ru.otus.spgboot.dao;

import ru.otus.spgboot.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getAllQuestions();

}
