package com.sb.inclass.project.sbinclassproject1.exception;

public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable ex) {
        super(message, ex);
    }
}
