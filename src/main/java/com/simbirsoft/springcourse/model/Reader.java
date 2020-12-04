package com.simbirsoft.springcourse.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(required = true, value = "Имя читателя", example = "Alex")
    @Column(name = "name")
    private String name;

    @ApiParam(required = true, value = "Дата рождения", example = "2000-01-01")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
