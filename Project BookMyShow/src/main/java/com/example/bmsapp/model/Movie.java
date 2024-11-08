package com.example.bmsapp.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;
    private String decription;
    private int releaseDate;

}
