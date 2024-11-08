package com.example.ecom.controllers;

import com.example.ecom.dtos.*;
import com.example.ecom.exceptions.*;
import com.example.ecom.models.Notification;
import com.example.ecom.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public RegisterUserForNotificationResponseDto registerUser(RegisterUserForNotificationRequestDto requestDto) {
        RegisterUserForNotificationResponseDto response = new RegisterUserForNotificationResponseDto();
        try{
            Notification notification = notificationService.registerUser(
                    requestDto.getUserId(),
                    requestDto.getProductId()
            );
            response.setNotification(notification);
            response.setResponseStatus(ResponseStatus.SUCCESS);

        }catch (UserNotFoundException userNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(userNotFoundException.getMessage());
        }catch (ProductNotFoundException productNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(productNotFoundException.getMessage());
        }catch (ProductInStockException productInStockException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(productInStockException.getMessage());
        }
        return response;
    }

    public DeregisterUserForNotificationResponseDto deregisterUser(DeregisterUserForNotificationRequestDto requestDto) {
        DeregisterUserForNotificationResponseDto response = new DeregisterUserForNotificationResponseDto();
        try{
            notificationService.deregisterUser(
                    requestDto.getUserId(),
                    requestDto.getNotificationId()
            );
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (UserNotFoundException userNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(userNotFoundException.getMessage());
        }catch (NotificationNotFoundException notificationNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(notificationNotFoundException.getMessage());
        }catch (UnAuthorizedException unAuthorizedException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(unAuthorizedException.getMessage());
        }
        return response;
    }
}
