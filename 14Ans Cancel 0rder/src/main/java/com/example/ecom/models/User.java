package com.example.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;


import java.util.List;

@Data
@Entity(name = "user_class")
public class User extends BaseModel{
    private String name;
    private String email;
    @ManyToMany
    private List<Order> orders;
}
