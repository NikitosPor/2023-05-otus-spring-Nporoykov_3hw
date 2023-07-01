package ru.otus.spgboot.service;

import org.springframework.stereotype.Service;
import ru.otus.spgboot.configs.AppLocalizedProps;
import ru.otus.spgboot.domain.TestResult;
import ru.otus.spgboot.helpers.IOService;


@Service
public class ResultsOutputServiceImpl implements ResultsOutputService {
    private final IOService ioService;

    private final AppLocalizedProps appLocalizedProps;

    public ResultsOutputServiceImpl(IOService ioService, AppLocalizedProps appLocalizedProps) {
        this.ioService = ioService;
        this.appLocalizedProps = appLocalizedProps;
    }

    public void printResults(TestResult testResult, int minRightAnswers) {
        String localizedSting;
        ioService.outputString(testResult.getStudent().getFullName() +
                appLocalizedProps.getLocalizedProperty("properties.output.exam.result",
                        new Integer[]{testResult.getRightAnswerCounter()}));
        if (testResult.getRightAnswerCounter() < minRightAnswers) {
            localizedSting = appLocalizedProps.getLocalizedProperty("properties.output.exam.negative");
            ioService.outputString(localizedSting);
        } else {
            localizedSting = appLocalizedProps.getLocalizedProperty("properties.output.exam.positive");
            ioService.outputString(localizedSting);
        }
    }
}
