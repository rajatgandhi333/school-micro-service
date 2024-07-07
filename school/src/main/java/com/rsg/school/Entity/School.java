package com.rsg.school.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}
