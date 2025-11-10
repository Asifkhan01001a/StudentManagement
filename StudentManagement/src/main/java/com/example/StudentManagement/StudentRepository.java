package com.example.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<Integer,Student>studentDb=new HashMap<>();

    public String addStudent(Student student){
        if(studentDb.containsKey(student.getId())){
            return "Student Already Exist";
        }
        studentDb.put(student.getId(),student);
        return "Student added Succesfully";
    }

    public List<Student> addStudent() {
        return new ArrayList<>(studentDb.values());
    }

    public Student getStudentById(int id) {
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }
}
