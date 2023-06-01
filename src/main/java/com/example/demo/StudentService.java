package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentService {

    @Autowired
    StudentDB db;

    @CrossOrigin
    @RequestMapping("/students")
    @ResponseBody
    public List<Students> getAllStudents() {
       return db.findAll();
    }

    @CrossOrigin
    @RequestMapping("/students/{roll}")
    public Students getStudent(@PathVariable("roll") int i) {

        return db.findByRoll(i);
    }

    @CrossOrigin
    @PostMapping(value = "/addStudent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Students addStudent(@RequestBody Students student){
        db.save(student);
        return student;
    }
    @CrossOrigin
    @DeleteMapping("/deleteStudent/{roll}")
    public String deleteStudent(@PathVariable("roll") int i)
    {
        Students s=db.getReferenceById(i);
        db.delete(s);
        return "success";
    }

    @PutMapping(path="/updateStudent")
    public  Students updateStudent(Students student)  // save or update
    {
       db.save(student);
       return student;
    }


}
