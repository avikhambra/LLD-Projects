package com.example.bmsapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Payment extends BaseModel{

    private int refNo;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String gateWay;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    private int amount;


}
