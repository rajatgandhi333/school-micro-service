package com.rsg.school.controller;


import com.rsg.school.Entity.School;
import com.rsg.school.dto.SchoolDTOResponse;
import com.rsg.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    @Autowired
    private SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody School school) {
        service.save(school);
    }


    @GetMapping("/findall")
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<SchoolDTOResponse> findSchoolwithStudents(@PathVariable("${school-id}") Integer schoolId) {
        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }
}
