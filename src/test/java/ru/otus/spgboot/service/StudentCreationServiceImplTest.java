package ru.otus.spgboot.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spgboot.helpers.IOService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("Class StudentCreationServiceImpl must be able to:")
@SpringBootTest()
class StudentCreationServiceImplTest {

    private static final String STUDENT_name = "Ivan";

    private static final String STUDENT_surename = "Drago";

    private static final String STUDENT_FULLNAME = "Ivan Drago";

    @MockBean
    private IOService ioService;

    @MockBean
    private AppRunService appRunService;

    @Autowired
    private StudentCreationService studentCreationService;

    @DisplayName("Create a student")
    @Test
    void askNameAndCreateStudentTest() {
        when(ioService.readString()).thenReturn(STUDENT_name, STUDENT_surename);
        var testStudent = studentCreationService.askNameAndCreateStudent();
        assertEquals(STUDENT_FULLNAME, testStudent.getFullName());
    }
}