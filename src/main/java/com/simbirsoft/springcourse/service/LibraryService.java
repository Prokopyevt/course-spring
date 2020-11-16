package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;

public interface LibraryService {

    Library getById(Long id);
    void save(LibraryDto libraryDto );
    void delete(Long id);
}
