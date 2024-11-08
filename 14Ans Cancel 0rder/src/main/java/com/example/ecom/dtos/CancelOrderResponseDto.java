package com.example.ecom.dtos;

import com.example.ecom.models.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CancelOrderResponseDto {
    private ResponseStatus status;
    private Order order;
}
