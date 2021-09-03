package com.example.demo;

import com.example.exception.FailedToAddStudentException;
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

    public void addStudent(Student student) throws StudentAlreadyExistsException {
        boolean studentExists = false;
        List<Student> studentList = studentRepository.findAll();
        for(Student stu : studentList){
            if(stu.getId().equals(student.getId())){
                System.out.println("Stu = " + stu.getId().toString() + "Student" + student.getId().toString());
                studentExists = true;

            }
            if(studentExists){
                throw new StudentAlreadyExistsException("Student with ID already exists");
            }
        }
        try{
            studentRepository.save(student);
        }catch(Exception e){
            throw e;
        }


    }
}
