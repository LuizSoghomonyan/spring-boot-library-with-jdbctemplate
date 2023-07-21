package com.example.springbootlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name = "person")
public class Person {
//    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    @NotBlank
    @Size(min = 2,
            max = 30,
            message = "Firstname should be between 2 and 30 characters")
    private String firstname;

    @Column(name = "lastname")
    @NotBlank
    @Size(min = 2,
            max = 30,
            message = "Lastname should be between 2 and 30 characters")
    private String lastname;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater then 0")
    private int age;

//    @Size(min = 1900,
//            max = 2023,
//            message = "Year should be between 1900 and 2023")
    @Column(name = "birthyear")
    @Min(value = 1900, message = "Year should be between 1900 and 2023")
    @Max(value = 2023, message = "Year should be between 1900 and 2023")
    private int birthYear;


}
