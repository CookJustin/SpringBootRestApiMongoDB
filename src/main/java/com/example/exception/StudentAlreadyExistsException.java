package com.example.exception;

import com.example.demo.Student;

public class StudentAlreadyExistsException extends RuntimeException{
    private String message;
    public StudentAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
    public StudentAlreadyExistsException(String message, Throwable cause){
        super(message,cause);

    }
}
