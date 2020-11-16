package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;

public interface ReadingRoomService {

    ReadingRoom getById(Long id);
    void save(ReadingRoomDto readingRoomDto);
    void delete(Long id);
}
