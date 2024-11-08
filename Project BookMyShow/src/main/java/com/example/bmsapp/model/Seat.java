package com.example.bmsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel{

    private int seatNumber;

    @OneToOne
    private SeatType seatType;
    private int rowNum;
    private int colNum;


}
