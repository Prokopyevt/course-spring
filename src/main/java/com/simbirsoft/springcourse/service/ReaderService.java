package com.simbirsoft.springcourse.service;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;

public interface ReaderService {

    Reader getById(Long id);
    void save(ReaderDto readerDto);
    void delete(Long id);
}
