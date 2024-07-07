package com.rsg.school.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private String firstname;
    private String lastname;
    private String email;
}
