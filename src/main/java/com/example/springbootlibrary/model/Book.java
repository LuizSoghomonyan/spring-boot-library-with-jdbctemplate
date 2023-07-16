package com.example.springbootlibrary.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class Book {
    private int id;

    @NotEmpty
    private String name;

    @NotBlank
    private String author;

    @Min(value = 0, message = "Year should be greater then 0")
    private int year;
}

