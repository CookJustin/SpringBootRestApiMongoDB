package com.example.demo;

import com.example.exception.StudentAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service //spring initializes this class as a bean
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        boolean studentExists = false;
        List<Student> studentList = studentRepository.findAll();
        for(Student stu : studentList){
            if(stu.getId().equals(student.getId())){
                studentExists = true;

            }
            if(studentExists){
                throw new StudentAlreadyExistsException("Student with ID already exists");
            }
        }
        studentRepository.save(student);

    }
}
