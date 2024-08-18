package com.springboot.inotebook.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

//@Data
public record INoteBookException(String message, Throwable throwable, HttpStatus httpStatus) {
}
