package com.example.bmsapp;

import com.example.bmsapp.controller.UserController;

import com.example.bmsapp.dtos.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        SignupRequestDto signupRequestDto = new SignupRequestDto();
//		signupRequestDto.setEmail("prashant@gmail.com");
//		signupRequestDto.setPassword("prahsant123");
//
//		userController.signup(signupRequestDto);

       System.out.println("userController.login(\"prashant@gmail.com\", \"prasant@123\") = "
                + userController.login("prashant@gmail.com", "prahsant123"));



    }
}
