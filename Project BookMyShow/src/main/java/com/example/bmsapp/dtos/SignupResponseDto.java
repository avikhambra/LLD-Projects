package com.example.bmsapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupResponseDto {

    private Long userId;
    private ResponseStatus responseStatus;
}
