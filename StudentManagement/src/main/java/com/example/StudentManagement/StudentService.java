package com.example.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public List<Student> getAllStudent() {
        return studentRepository.addStudent();
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }
}
