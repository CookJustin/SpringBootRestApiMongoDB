package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service //spring initializes this class as a bean
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with id " + id + " does not exist"));
    }

    public Student addStudent(Student student) throws IllegalArgumentException {
        try {
            return studentRepository.save(student);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Student Given", e);
        }
    }

    public Student updateStudent(String id, Student student) {
            Student updatedStudent = studentRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with id " + id + " does not exist"));
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setGender(student.getGender());
            updatedStudent.setFavouriteSubjects(student.getFavouriteSubjects());
            updatedStudent.setTotalSpentInBooks(student.getTotalSpentInBooks());
        return updatedStudent;
    }

    public Student deleteStudent(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with id " + id + " does not exist"));
        try{
            studentRepository.delete(student);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with id " + id + " does not exist", e);
        }
        return student;
    }
}
