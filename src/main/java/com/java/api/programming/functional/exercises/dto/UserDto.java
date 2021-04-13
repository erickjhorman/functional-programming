package com.java.api.programming.functional.exercises.dto;

import com.java.api.programming.functional.exercises.entity.User;
import lombok.*;

import java.time.LocalDate;

@Setter  @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String firstName;
    private boolean active;

    public UserDto(User user) {
        this.setUserName(user.getUserName());
        this.setFirstName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        this.setActive(user.getDeactivationDate() == null);
    }
}