package com.simbirsoft.springcourse.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReaderDto {

    private String name;
    private LocalDate dateOfBirth;

}
