package com.simbirsoft.springcourse.model;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiParam(required = true, value = "Название книги")
    @Column(name = "name_book")
    private String nameBook;

    @ApiParam(required = true, value = "Автор")
    @Column(name = "author")
    private String author;

    @ApiParam(required = true, value = "Год издания")
    @Column(name = "year_of_publishing")
    private Integer yearOfPublishing;

    @ApiParam(required = true, value = "Статус")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
