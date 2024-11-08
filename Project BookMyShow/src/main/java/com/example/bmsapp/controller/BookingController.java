package com.example.bmsapp.controller;

import com.example.bmsapp.dtos.BookMovieRequestDto;
import com.example.bmsapp.dtos.BookMovieResponseDto;
import com.example.bmsapp.dtos.ResponseStatus;
import com.example.bmsapp.exceptions.InvalidShowException;
import com.example.bmsapp.exceptions.InvalidUserException;
import com.example.bmsapp.exceptions.SeatsUnavailableException;
import com.example.bmsapp.model.Booking;
import com.example.bmsapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    public BookMovieResponseDto bookMovie(BookMovieRequestDto request){

        try {

            Booking booking = bookingService.bookMovie(request);

            return new BookMovieResponseDto(booking.getId(), Long.valueOf(booking.getAmount()),
                    ResponseStatus.SUCCESS, "Successfully booked the ticket ");
        } catch (InvalidUserException e) {
            return new BookMovieResponseDto(null, 0L, ResponseStatus.FAILURE,
                    "User is not present");
        } catch (InvalidShowException e) {
            return new BookMovieResponseDto(null, 0L, ResponseStatus.FAILURE,
                    "show is not present");
        } catch (SeatsUnavailableException e) {
            return new BookMovieResponseDto(null, 0L, ResponseStatus.FAILURE,
                    "seats are not available");
        }
    }
}
