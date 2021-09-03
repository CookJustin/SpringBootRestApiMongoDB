package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Failed to add Student")
public class FailedToAddStudentException extends Exception{
    public FailedToAddStudentException(String message){
        super(message);
    }
}
