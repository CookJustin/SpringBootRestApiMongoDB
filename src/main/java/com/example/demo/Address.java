package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data //@Data Removes Boilerplate code with Lombok ( Generated getters and setters )
@AllArgsConstructor
public class Address {
    private String country;
    private String city;
    private String postCode;

}
