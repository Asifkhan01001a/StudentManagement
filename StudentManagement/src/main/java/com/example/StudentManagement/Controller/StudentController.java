package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/Welcome")
    public String getWelcome(int id){
        return "Welcome";
    }

    //to add students in hashmap
    @PostMapping
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //to get all records in hashmap
    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }


    @GetMapping()
    public Student getStudentByIdPath(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/id/{id}/age/{age}")
    public String updateAge(@PathVariable("id") int id,
                            @PathVariable("age") int age){
        return studentService.updateAge(id,age);
    }

    @PutMapping
    public String updateAgeUsingReqParam(@RequestParam("id") int id,
                                         @RequestParam("age") int age){
        return studentService.updateAge(id,age);
    }

    @DeleteMapping
    public String deleteStudent(@RequestParam("id") int id){
        return studentService.deleteStudent(id);
    }




}
