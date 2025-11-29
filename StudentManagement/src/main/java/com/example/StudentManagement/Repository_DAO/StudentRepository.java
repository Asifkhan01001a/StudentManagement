package com.example.StudentManagement.Repository_DAO;

import com.example.StudentManagement.Exceptions.StudentException;
import com.example.StudentManagement.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer, Student>studentDb=new HashMap<>();

    public String addStudent(Student student){
        if(studentDb.containsKey(student.getId())){
            throw new StudentException("this student alraedy exist");
        }
        studentDb.put(student.getId(),student);
        return "student added succesfully";

    }

    public List<Student> getAllStudentList() {
        return new ArrayList<>(studentDb.values());
    }

    public Student getStudentById(int id) {
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    public String updateAge(int id, int age) {
        if(!studentDb.containsKey(id)){
            throw new StudentException("id " + id + " invalid");
        }
        Student existingStudent = studentDb.get(id);
        existingStudent.setAge(age);
        studentDb.put(id,existingStudent);
        return "age update succesfull";
    }

    public String deleteStudent(int id) {
        if(!studentDb.containsKey(id)){
            throw new StudentException("id " + id + " is not present in database ");
        }
        studentDb.remove(id);
        return "student delete succesfully";
    }
}
