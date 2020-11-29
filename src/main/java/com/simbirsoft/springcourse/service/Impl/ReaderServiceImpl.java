package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.mapper.ReaderMapper;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.repository.ReaderRepository;
import com.simbirsoft.springcourse.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@AllArgsConstructor
public class ReaderServiceImpl implements ReaderService {

    private ReaderMapper readerMapper;
    private final ReaderRepository readerRepository;

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
      //  if (isEmpty(readerDto)) {
        //    throw new NullPointerException("Пустое значение");
       // }
        return readerRepository.save(readerMapper.toReader(readerDto));
    }

    @Override
    public void delete(Long id) {
        readerRepository.deleteById(id);
    }
}

