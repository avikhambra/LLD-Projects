package com.example.bmsapp.controller;

import com.example.bmsapp.dtos.ResponseStatus;
import com.example.bmsapp.dtos.SignupRequestDto;
import com.example.bmsapp.dtos.SignupResponseDto;
import com.example.bmsapp.model.User;
import com.example.bmsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public SignupResponseDto signup(SignupRequestDto requestDto){

        User user = userService.signUp(requestDto.getEmail(), requestDto.getPassword());
        return new SignupResponseDto(user.getId(), ResponseStatus.SUCCESS);

    }

    public boolean login(String email, String password){
        return userService.login(email, password);
    }

}
