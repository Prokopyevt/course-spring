package com.simbirsoft.springcourse.dto;

import com.simbirsoft.springcourse.model.Status;
import lombok.Data;

@Data
public class LibraryDto {

    private String nameBook;
    private String author;
    private Integer yearOfPublishing;
    private Status status;
}
