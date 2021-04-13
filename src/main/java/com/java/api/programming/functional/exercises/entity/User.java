package com.java.api.programming.functional.exercises.entity;

import lombok.Data;

import java.time.LocalDate;


@Data
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDate deactivationDate;


    public String getDeactivationDate() {
        return null;
    }
}
