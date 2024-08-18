package com.springboot.inotebook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHander {

    @ExceptionHandler(value={BookNotFoundException.class})
    public ResponseEntity<?> bookNotFoundExeptionHandler(BookNotFoundException bookNotFoundException){
        INoteBookException iNoteBookException = new INoteBookException(bookNotFoundException.getMessage(),
                bookNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(iNoteBookException, HttpStatus.NOT_FOUND);
    }
}
