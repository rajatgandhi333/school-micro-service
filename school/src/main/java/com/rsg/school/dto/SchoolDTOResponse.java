package com.rsg.school.dto;

import com.rsg.school.Entity.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SchoolDTOResponse {

    private String name;
    private String email;
    private List<Student> students;
}
