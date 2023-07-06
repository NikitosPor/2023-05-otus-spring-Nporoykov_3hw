package ru.otus.spgboot.service;

import org.springframework.stereotype.Service;
import ru.otus.spgboot.helpers.LocalizedPropsProvider;
import ru.otus.spgboot.domain.Student;
import ru.otus.spgboot.helpers.IOService;

@Service
public class StudentCreationServiceImpl implements StudentCreationService {

    private final IOService ioService;

    private final LocalizedPropsProvider localizedPropsProvider;

    public StudentCreationServiceImpl(IOService ioService, LocalizedPropsProvider localizedPropsProvider) {
        this.ioService = ioService;
        this.localizedPropsProvider = localizedPropsProvider;
    }

    public Student askNameAndCreateStudent() {

        ioService.outputString(localizedPropsProvider.getLocalizedProperty("properties.input.name"));
        String name = ioService.readString();
        ioService.outputString(localizedPropsProvider.getLocalizedProperty("properties.input.surename"));
        String sureName = ioService.readString();

        return new Student(name, sureName);
    }


}
