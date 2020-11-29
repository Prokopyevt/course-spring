package com.simbirsoft.springcourse.mapper;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.model.Reader;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    Reader toReader (ReaderDto readerDto);

}
