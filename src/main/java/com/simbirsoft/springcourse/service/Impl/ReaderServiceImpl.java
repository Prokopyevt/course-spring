package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.repository.ReaderRepository;
import com.simbirsoft.springcourse.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public Reader getById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ReaderDto readerDto) {
    Reader reader = new Reader();
    reader.setName(readerDto.getName());
    reader.setDateOfBirth(readerDto.getDateOfBirth());
    readerRepository.save(reader);
    }

    @Override
    public void delete(Long id) {
    readerRepository.deleteById(id);
    }
}
