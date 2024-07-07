package com.rsg.school.service;

import com.rsg.school.Entity.School;
import com.rsg.school.Entity.Student;
import com.rsg.school.client.StudentClient;
import com.rsg.school.dto.SchoolDTOResponse;
import com.rsg.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository repository;

    @Autowired
    private StudentClient client;


    public void save(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }


    public SchoolDTOResponse findSchoolWithStudents(Integer schoolId) {
        School school = repository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND").
                        email("NOT_FOUND").
                        build());
        List<Student> students = client.getAllStudentBySchool(schoolId);
        return SchoolDTOResponse.builder().
                students(students)
                .email(school.getEmail())
                .name(school.getName()).
                build();

    }
}
