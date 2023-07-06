package ru.otus.spgboot.service;

import org.springframework.stereotype.Service;
import ru.otus.spgboot.helpers.LocalizedPropsProvider;
import ru.otus.spgboot.configs.MinRightCountProvider;
import ru.otus.spgboot.domain.TestResult;
import ru.otus.spgboot.helpers.IOService;


@Service
public class ResultsOutputServiceImpl implements ResultsOutputService {
    private final IOService ioService;

    private final LocalizedPropsProvider localizedPropsProvider;

    private final MinRightCountProvider minRightCountProvider;

    public ResultsOutputServiceImpl(IOService ioService,
                                    LocalizedPropsProvider localizedPropsProvider,
                                    MinRightCountProvider minRightCountProvider) {
        this.ioService = ioService;
        this.localizedPropsProvider = localizedPropsProvider;
        this.minRightCountProvider = minRightCountProvider;
    }

    public void printResults(TestResult testResult) {
        String localizedSting;
        ioService.outputString(testResult.getStudent().getFullName() +
                localizedPropsProvider.getLocalizedProperty("properties.output.exam.result",
                        new Integer[]{testResult.getRightAnswerCounter()}));
        if (testResult.getRightAnswerCounter() < minRightCountProvider.getMinRightCount()) {
            localizedSting = localizedPropsProvider.getLocalizedProperty("properties.output.exam.negative");
            ioService.outputString(localizedSting);
        } else {
            localizedSting = localizedPropsProvider.getLocalizedProperty("properties.output.exam.positive");
            ioService.outputString(localizedSting);
        }
    }
}
