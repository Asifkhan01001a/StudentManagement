package com.example.StudentManagement.Repository_DAO;

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

    public String updateAge(int id, int age) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id ";
        }
        Student existingStudent = studentDb.get(id);
        existingStudent.setAge(age);
        studentDb.put(id,existingStudent);
        return "age update succesfull";
    }

    public String deleteStudent(int id) {
        if(!studentDb.containsKey(id)){
            return "Invalid id";
        }
        studentDb.remove(id);
        return "student delete succesfully";
    }
}
