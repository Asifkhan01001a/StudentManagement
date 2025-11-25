package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Teacher;
import com.example.StudentManagement.Repository_DAO.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;


    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public String updateTeacher(int id, int salary) {
        return teacherRepository.updateTeacher(id,salary);
    }
}
