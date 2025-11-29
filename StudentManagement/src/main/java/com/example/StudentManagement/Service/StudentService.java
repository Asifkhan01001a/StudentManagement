package com.example.StudentManagement.Service;

import com.example.StudentManagement.Exceptions.StudentException;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Repository_DAO.StudentRepository;
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

    public List<Student> getAllStudentList() {
        if(studentRepository.getAllStudentList().size()==0){
            throw new StudentException("List is Empty Add Students ");
        }
        return studentRepository.getAllStudentList();
    }

    public Student getStudentById(int id) {
        Student student=studentRepository.getStudentById(id);
        if(student==null){
            throw new StudentException("id " + id + " invalid");
        }
        return student;
    }

    public String updateAge(int id, int age) {
        return studentRepository.updateAge(id,age);
    }

    public String deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}
