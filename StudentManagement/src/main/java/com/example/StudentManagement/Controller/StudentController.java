package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")

public class StudentController {
    @Autowired
    StudentService studentService;


    Logger logger= LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/Welcome")
    public String getWelcome(int id){
        return "Welcome";
    }

    //to add students in hashmap
    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){
        try{
            logger.warn("Student input recived : "+ student);
//            logger.info("Student input recived : "+ student);
            return new ResponseEntity(studentService.addStudent(student),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

    //to get all records in hashmap
    @GetMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") int id){
        try{
            Student student = studentService.getStudentById(id);
            return new ResponseEntity(student, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/all")
    public ResponseEntity getAllStudentList(){
        try{
            return new ResponseEntity(studentService.getAllStudentList(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping()
    public ResponseEntity getStudentByIdPath(@RequestParam("id") int id){

        try{
            Student student = studentService.getStudentById(id);
            return new ResponseEntity(student, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/id/{id}/age/{age}")
    public ResponseEntity updateAge(@PathVariable("id") int id,
                            @PathVariable("age") int age){
        try{
            return new ResponseEntity(studentService.updateAge(id,age),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping
    public ResponseEntity updateAgeUsingReqParam(@RequestParam("id") int id,
                                         @RequestParam("age") int age){
        try{
            return new ResponseEntity(studentService.updateAge(id,age),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestParam("id") int id){
        try{
            return new ResponseEntity(studentService.deleteStudent(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }




}
