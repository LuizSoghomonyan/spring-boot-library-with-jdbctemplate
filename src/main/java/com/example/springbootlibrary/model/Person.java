package com.example.springbootlibrary.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Person {
    @NotBlank
    private int id;

    @NotBlank
    @Size(min = 2,
            max = 30,
            message = "Firstname should be between 2 and 30 characters")
    private String firstname;

    @NotBlank
    @Size(min = 2,
            max = 30,
            message = "Lastname should be between 2 and 30 characters")
    private String lastname;

    @NotBlank
    @Email
    private String email;

    @Min(value = 0, message = "Age should be greater then 0")
    private int age;

    @Size(min = 1900,
            max = 2023,
            message = "Year should be between 1900 and 2023")
    private int birthYear;


}
