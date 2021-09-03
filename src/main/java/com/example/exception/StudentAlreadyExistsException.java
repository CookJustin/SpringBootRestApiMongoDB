package com.example.exception;

import com.example.demo.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Student already exists")
public class StudentAlreadyExistsException extends Exception{
    public StudentAlreadyExistsException(String message){
        super(message);
    }

}
