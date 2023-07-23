package com.example.springbootlibrary.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_registered")
    private Date dateRegistered;

}
