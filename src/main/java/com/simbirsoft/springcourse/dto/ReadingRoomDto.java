package com.simbirsoft.springcourse.dto;

import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.model.Reader;

public class ReadingRoomDto {

    private Long libraryId;
    private Long readerId;
    private Integer residueReader;

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Integer getResidueReader() {
        return residueReader;
    }

    public void setResidueReader(Integer residueReader) {
        this.residueReader = residueReader;
    }
}
