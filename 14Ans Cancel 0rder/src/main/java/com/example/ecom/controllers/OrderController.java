package com.example.ecom.controllers;

import com.example.ecom.dtos.CancelOrderRequestDto;
import com.example.ecom.dtos.CancelOrderResponseDto;
import com.example.ecom.dtos.ResponseStatus;
import com.example.ecom.exceptions.OrderCannotBeCancelledException;
import com.example.ecom.exceptions.OrderDoesNotBelongToUserException;
import com.example.ecom.exceptions.OrderNotFoundException;
import com.example.ecom.exceptions.UserNotFoundException;
import com.example.ecom.models.Order;
import com.example.ecom.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public CancelOrderResponseDto cancelOrder(CancelOrderRequestDto cancelOrderRequestDto) {

        CancelOrderResponseDto response = new CancelOrderResponseDto();
        int id = cancelOrderRequestDto.getOrderId();
        System.out.println("Cancelling the order for "+ id);

        try{
            Order order = orderService.cancelOrder(cancelOrderRequestDto.getOrderId(), cancelOrderRequestDto.getUserId());
            response.setOrder(order);
            response.setStatus(ResponseStatus.SUCCESS);
            System.out.println("Success for "+ id +" ..");

        }catch (UserNotFoundException | OrderNotFoundException | OrderDoesNotBelongToUserException | OrderCannotBeCancelledException userNotFoundException){

            response.setStatus(ResponseStatus.FAILURE);
            System.out.println(userNotFoundException.getMessage() + id);

        }
        return response;
    }

}
