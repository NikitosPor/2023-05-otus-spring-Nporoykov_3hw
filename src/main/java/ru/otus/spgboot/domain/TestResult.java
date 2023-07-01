package ru.otus.spgboot.domain;

public class TestResult {
    private Student student;

    private int rightAnswerCounter;

    private int minRightAnswers;

    public TestResult() {
    }

    public TestResult(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    public void setRightAnswerCounter(int rightAnswerCounter) {
        this.rightAnswerCounter = rightAnswerCounter;
    }

    public int getMinRightAnswers() {
        return minRightAnswers;
    }

    public void setMinRightAnswers(int minRightAnswers) {
        this.minRightAnswers = minRightAnswers;
    }
}

