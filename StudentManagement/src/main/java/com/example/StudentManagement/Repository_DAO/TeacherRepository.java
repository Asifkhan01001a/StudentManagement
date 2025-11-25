package com.example.StudentManagement.Repository_DAO;

import com.example.StudentManagement.Exceptions.TeacherExistException;
import com.example.StudentManagement.Model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Slf4j

@Repository
public class TeacherRepository {

    HashMap<Integer, Teacher>teachersDb=new HashMap<>();


    public String addTeacher(Teacher teacher) {
        if(teachersDb.containsKey(teacher.getId())) {
            throw new TeacherExistException("Id: "+ teacher.getId()+ " already exisits");
        }
        teachersDb.put(teacher.getId(),teacher);
        log.info("Teacher with id: "+teacher.getId()+ " added");
        return "Teacher added successfully";
    }

    public Teacher getTeacherById(int id) {
        if(!teachersDb.containsKey(teachersDb.get(id))){
            return null;
        }
        return teachersDb.get(id);
    }

    public String updateTeacher(int id, int salary) {
        if(!teachersDb.containsKey(id)){
            return "invalid id";
        }
        Teacher teacher = teachersDb.get(id);
        teacher.setSalary(salary);
        teachersDb.put(id,teacher);
        return "salary update succesfully";
    }
}
