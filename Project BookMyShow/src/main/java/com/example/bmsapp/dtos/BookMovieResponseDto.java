package com.example.bmsapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class BookMovieResponseDto {

    private Long bookingId;
    private Long amount;
    private ResponseStatus responseStatus;
    private String responseMessage;

}
