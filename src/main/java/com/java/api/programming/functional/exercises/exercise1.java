package com.java.api.programming.functional.exercises;

import com.java.api.programming.functional.exercises.dto.UserDto;
import com.java.api.programming.functional.exercises.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class UserFacade {
    private UserRepo userRepo;
    private UserMappper mappper;

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
    public List<UserDto> getAllUsersFunctionalWithMapper() {
        return userRepo.findAll().stream().map(mappper::toDto).collect(Collectors.toList());
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
        return userDto;

    }
}


interface UserRepo {
    List<User> findAll();
}

@Component
class UserMappper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto(user);
        userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        userDto.setActive(user.getDeactivationDate() == null);
        return userDto;

    }
}



public class exercise1 {


}
