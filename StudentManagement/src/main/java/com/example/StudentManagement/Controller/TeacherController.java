package com.example.StudentManagement.Controller;


import com.example.StudentManagement.Exceptions.TeacherExistException;
import com.example.StudentManagement.Model.Teacher;
import com.example.StudentManagement.Service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        try{
            log.info("Teacher input received: "+teacher);
            String response = teacherService.addTeacher(teacher);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (TeacherExistException e) {
            log.error("Exception while adding teacher: "+e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public Teacher getTeacherById(@RequestParam("id") int id){
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}/{salary}")
    public String updateTeacher(@PathVariable("id") int id,
                                 @PathVariable("salary") int salary){
        return teacherService.updateTeacher(id,salary);
    }

}
