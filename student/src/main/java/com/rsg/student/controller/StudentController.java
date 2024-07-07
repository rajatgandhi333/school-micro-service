package com.rsg.student.controller;

import com.rsg.student.entity.Student;
import com.rsg.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/findall")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findBySchoolId(@RequestParam("${school-id}") Integer schoolid) {
        return ResponseEntity.ok(service.findBySchoolId(schoolid));
    }
}
