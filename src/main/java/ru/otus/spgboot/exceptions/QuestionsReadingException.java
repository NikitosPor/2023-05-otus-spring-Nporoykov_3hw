package ru.otus.spgboot.exceptions;

import java.io.IOException;

public class QuestionsReadingException extends RuntimeException{
    public QuestionsReadingException(IOException e) {
        super(e);
    }
}
