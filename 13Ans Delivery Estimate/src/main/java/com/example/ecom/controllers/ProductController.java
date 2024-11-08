package com.example.ecom.controllers;

import com.example.ecom.dtos.DeliveryEstimateRequestDto;
import com.example.ecom.dtos.DeliveryEstimateResponseDto;
import com.example.ecom.dtos.ResponseStatus;
import com.example.ecom.exceptions.AddressNotFoundException;
import com.example.ecom.exceptions.ProductNotFoundException;
import com.example.ecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
public class ProductController {

    private ProductService productService;

     @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public DeliveryEstimateResponseDto estimateDeliveryTime(DeliveryEstimateRequestDto requestDto){
         DeliveryEstimateResponseDto response = new DeliveryEstimateResponseDto();

        try{
            Date date = productService.estimateDeliveryDate(
                    requestDto.getProductId(),
                    requestDto.getAddressId()
            );

            response.setExpectedDeliveryDate(date);
            response.setResponseStatus(ResponseStatus.SUCCESS);


        }catch (ProductNotFoundException productNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(productNotFoundException.getMessage());
        }catch (AddressNotFoundException addressNotFoundException){
            response.setResponseStatus(ResponseStatus.FAILURE);
            System.out.println(addressNotFoundException.getMessage());
        }

        return response;
    }
}
