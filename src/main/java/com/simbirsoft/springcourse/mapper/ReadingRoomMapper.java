package com.simbirsoft.springcourse.mapper;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.model.ReadingRoom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReadingRoomMapper {

    ReadingRoom toReadingRoom (ReadingRoomDto readingRoomDto);

}
