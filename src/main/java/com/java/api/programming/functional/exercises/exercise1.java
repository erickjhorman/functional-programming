package com.java.api.programming.functional.exercises;

import com.java.api.programming.functional.exercises.dto.UserDto;
import com.java.api.programming.functional.exercises.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class UserFacade {
    private UserRepo userRepo;

    //Imperative form
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        var userDtoList = new ArrayList<UserDto>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setUserName(user.getUserName());
            userDto.setFirstName(user.getFirstName() + " " + user.getLastName().toUpperCase());
            userDto.setActive(user.getDeactivationDate() == null);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    //functional programming
    public List<UserDto> getAllUsersFunctional() {
        return userRepo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setActive(user.getDeactivationDate() == null);
        return userDto;
    }

    //Called the same method but from dto contructor
    private UserDto toDtoFromContructor(User user) {
        UserDto userDto = new UserDto(user);
        /*
        userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setActive(user.getDeactivationDate() == null);
         */
        return userDto;

    }
}


interface UserRepo {
    List<User> findAll();
}


public class exercise1 {


}
