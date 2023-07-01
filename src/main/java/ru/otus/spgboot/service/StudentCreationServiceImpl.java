package ru.otus.spgboot.service;

import org.springframework.stereotype.Service;
import ru.otus.spgboot.configs.AppLocalizedProps;
import ru.otus.spgboot.domain.Student;
import ru.otus.spgboot.helpers.IOService;

@Service
public class StudentCreationServiceImpl implements StudentCreationService {

    private final IOService ioService;

    private final AppLocalizedProps appLocalizedProps;

    public StudentCreationServiceImpl(IOService ioService, AppLocalizedProps appLocalizedProps) {
        this.ioService = ioService;
        this.appLocalizedProps = appLocalizedProps;
    }

    public Student askNameAndCreateStudent() {

        ioService.outputString(appLocalizedProps.getLocalizedProperty("properties.input.name"));
        String name = ioService.readString();
        ioService.outputString(appLocalizedProps.getLocalizedProperty("properties.input.surename"));
        String sureName = ioService.readString();

        return new Student(name, sureName);
    }


}
