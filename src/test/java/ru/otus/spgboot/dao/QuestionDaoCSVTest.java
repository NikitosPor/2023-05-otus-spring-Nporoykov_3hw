package ru.otus.spgboot.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spgboot.domain.Answer;
import ru.otus.spgboot.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class LinesFromCsvFileDaoImpl must be able to:")
@SpringBootTest
class QuestionDaoCSVTest {

    private final List<Question> LIST_OF_QUESTIONS = new ArrayList<>();
    private static final Question QUESTION_1 = new Question("Who was a king?", List.of(new Answer("a)Ted", true), new Answer("b)Teena", false), new Answer("c)Kastro", false)));
    private static final Question QUESTION_2 = new Question("Where were this done?", List.of(new Answer("a)Home", false), new Answer("b)Street", true), new Answer("c)Sky", false)));

    @Autowired
    private QuestionDao questionDao;

    @BeforeEach
    void setUp() {
        LIST_OF_QUESTIONS.add(QUESTION_1);
        LIST_OF_QUESTIONS.add(QUESTION_2);
    }

    @DisplayName("Extract list of questions")
    @Test
    void getAllQuestionsAndAnswersTest() {
        var testList = questionDao.getAllQuestions();
        for (int i = 0; i < testList.size(); i++) {
            int finalI = i;
            String validatedQuestion = testList.get(finalI).getQuestion();
            List<Answer> validatedListOfAnswers = testList.get(finalI).getListOfAnswers();

            assertAll("question",
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getQuestion(), validatedQuestion),
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(0).getAnswer(), validatedListOfAnswers.get(0).getAnswer()),
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(1).getAnswer(), validatedListOfAnswers.get(1).getAnswer()),
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(2).getAnswer(), validatedListOfAnswers.get(2).getAnswer()),

                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(0).isCorrect(), validatedListOfAnswers.get(0).isCorrect()),
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(1).isCorrect(), validatedListOfAnswers.get(1).isCorrect()),
                    () -> assertEquals(LIST_OF_QUESTIONS.get(finalI).getListOfAnswers().get(2).isCorrect(), validatedListOfAnswers.get(2).isCorrect())
            );
        }
    }

}