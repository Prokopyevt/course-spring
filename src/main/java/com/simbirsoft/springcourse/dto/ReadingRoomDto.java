package com.simbirsoft.springcourse.dto;

import lombok.Data;

@Data
public class ReadingRoomDto {

    private Long libraryId;
    private Long readerId;
    private Integer residueReader;

}
