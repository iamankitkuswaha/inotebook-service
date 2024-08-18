package com.springboot.inotebook.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
