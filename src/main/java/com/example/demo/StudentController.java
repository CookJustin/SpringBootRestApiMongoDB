package com.example.demo;


import com.example.exception.StudentAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents(){
        return studentService.getAllStudents();
    }

//    @PostMapping
//    public void addStudent(@RequestBody Student student){
//        studentService.addStudent(student);
//    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student){

        try{
            studentService.addStudent(student);
        }catch(StudentAlreadyExistsException studentAlreadyExistsException){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not add Student", studentAlreadyExistsException);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not add Student", e);
        }
        return new ResponseEntity<>(student, HttpStatus.CREATED);


    }

}
