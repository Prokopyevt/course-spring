package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.repository.ReaderRepository;
import com.simbirsoft.springcourse.service.ReaderService;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class ReaderServiceImpl implements ReaderService {


    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader getById(Long id) {
        if (isEmpty(id)) {
            throw new NullPointerException("ID не найден");
        }
        Reader reader = readerRepository.findById(id).orElse(null);
        if (isEmpty(reader)) {
            throw new NullPointerException("Читатель не найден");
        }
        return reader;
    }

    @Override
    public Reader save(ReaderDto readerDto) {
        if (isEmpty(readerDto)) {
            throw new NullPointerException("Пустое значение");
        }
        Reader reader = new Reader();
        reader.setName(readerDto.getName());
        reader.setDateOfBirth(readerDto.getDateOfBirth());
        return readerRepository.save(reader);
    }

    @Override
    public void delete(Long id) {
        readerRepository.deleteById(id);
    }
}

