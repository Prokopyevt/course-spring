package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.mapper.ReadingRoomMapper;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.repository.ReadingRoomRepository;
import com.simbirsoft.springcourse.service.LibraryService;
import com.simbirsoft.springcourse.service.ReaderService;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@AllArgsConstructor
public class ReadingRoomImpl implements ReadingRoomService {


    private final ReadingRoomRepository readingRoomRepository;
    private final LibraryService libraryService;
    private final ReaderService readerService;
    private ReadingRoomMapper readingRoomMapper;

    @Override
    public ReadingRoom getById(Long id) {
        if (isEmpty(id)) {
            throw new NullPointerException("ID не найден");
        }
        ReadingRoom readingRoom = readingRoomRepository.findById(id).orElse(null);
        if (isEmpty(readingRoom)) {
            throw new NullPointerException("Контент отсутствует");
        }
        return readingRoom;
    }

    @Override
    public ReadingRoom save( ReadingRoomDto readingRoomDto) {
        if (isEmpty(readingRoomDto)) {
            throw new NullPointerException("Пустое значение");
       }
        return readingRoomRepository.save(readingRoomMapper.toReadingRoom(readingRoomDto));
    }

    @Override
    public void delete(Long id) {
        readingRoomRepository.delete(getById(id));
    }
}
