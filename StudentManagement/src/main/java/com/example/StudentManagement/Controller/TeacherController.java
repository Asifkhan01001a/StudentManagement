package com.example.StudentManagement.Controller;


import com.example.StudentManagement.Model.Teacher;
import com.example.StudentManagement.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping()
    public String addTeacher(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

}
