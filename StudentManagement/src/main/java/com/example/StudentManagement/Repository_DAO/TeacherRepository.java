package com.example.StudentManagement.Repository_DAO;

import com.example.StudentManagement.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class TeacherRepository {

    HashMap<Integer, Teacher>teacherDb=new HashMap<>();


    public String addTeacher(Teacher teacher) {
        if(teacherDb.containsKey(teacher.getId())){
            return "Teacher already exist";
        }
        teacherDb.put(teacher.getId(),teacher);
        return "Teacher added succesfully";
    }
}
