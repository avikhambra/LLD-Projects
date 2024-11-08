package com.example.ecom.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="User_Class")
public class User extends BaseModel{
    private String name;
    private String email;
}
