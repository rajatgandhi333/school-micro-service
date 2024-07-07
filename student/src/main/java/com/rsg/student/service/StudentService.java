package com.rsg.student.service;

import com.rsg.student.entity.Student;
import com.rsg.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public List<Student> findBySchoolId(Integer schoolid) {
        return repository.findAllBySchoolId(schoolid);
    }
}
