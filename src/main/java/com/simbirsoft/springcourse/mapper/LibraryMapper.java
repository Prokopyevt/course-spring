package com.simbirsoft.springcourse.mapper;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    Library toLibrary(LibraryDto libraryDto);

}
