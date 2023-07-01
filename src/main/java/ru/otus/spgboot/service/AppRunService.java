package ru.otus.spgboot.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.otus.spgboot.configs.AppLocalizedProps;
import ru.otus.spgboot.domain.TestResult;
import ru.otus.spgboot.exceptions.QuestionsReadingException;
import ru.otus.spgboot.helpers.IOService;

import java.io.IOException;

@Service
public class AppRunService implements CommandLineRunner {

    private final AppLocalizedProps appLocalizedProps;

    private final IOService ioService;

    private final QuestionAskService questionAskService;

    private final ResultsOutputService resultsOutputService;

    private final StudentCreationService studentCreationService;

    public AppRunService(QuestionAskService questionAskService,
                         AppLocalizedProps appLocalizedProps,
                         IOService ioService,
                         ResultsOutputService resultsOutputService,
                         StudentCreationService studentCreationService) {
        this.questionAskService = questionAskService;
        this.appLocalizedProps = appLocalizedProps;
        this.ioService = ioService;
        this.resultsOutputService = resultsOutputService;
        this.studentCreationService = studentCreationService;
    }

    public void run(String... args) {
        try {
            TestResult testResult = new TestResult();
            testResult.setStudent(studentCreationService.askNameAndCreateStudent());
            testResult.setRightAnswerCounter(questionAskService.askAllQuestionsAndReturnCounter());
            resultsOutputService.printResults(testResult, appLocalizedProps.getMinRightQuestionsCount());
        } catch (QuestionsReadingException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException ioException) {
                ioService.outputString(appLocalizedProps.getLocalizedProperty("properties.output.file.error"));
                ioException.printStackTrace(); // тут как я понимаю логирование вместо этого надо
            }
        }
    }
}

