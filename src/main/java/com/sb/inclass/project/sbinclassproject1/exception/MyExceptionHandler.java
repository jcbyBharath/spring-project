package com.sb.inclass.project.sbinclassproject1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String>  handle_custom_exception() {
        return new ResponseEntity<>("please don't enter exception as value in name", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String>  handle_aiofb_exception() {

        return new ResponseEntity<>("array index out of bounds", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
