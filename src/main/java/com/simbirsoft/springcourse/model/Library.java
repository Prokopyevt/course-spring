package com.simbirsoft.springcourse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(required = true, value = "Название книги", example = "Герой нашего времени")
    @Column(name = "name_book")
    private String nameBook;

    @ApiModelProperty(required = true, value = "Автор", example = "М.Ю.Лермонтов")
    @Column(name = "author")
    private String author;

    @ApiModelProperty(required = true, value = "Год издания", example = "1839")
    @Column(name = "year_of_publishing")
    private Integer yearOfPublishing;

    @ApiModelProperty(required = true, value = "Статус",example = "OPEN")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
