package com.simbirsoft.springcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "author")
    private String author;

    @Column(name = "year_of_publishing")
    private Integer yearOfPublishing;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
