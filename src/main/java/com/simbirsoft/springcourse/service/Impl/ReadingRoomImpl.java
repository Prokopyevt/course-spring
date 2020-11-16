package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.repository.ReadingRoomRepository;
import com.simbirsoft.springcourse.service.LibraryService;
import com.simbirsoft.springcourse.service.ReaderService;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingRoomImpl implements ReadingRoomService {

    @Autowired
    private ReadingRoomRepository readingRoomRepository;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private ReaderService readerService;

    @Override
    public ReadingRoom getById(Long id) {
        return  readingRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ReadingRoomDto readingRoomDto) {
        ReadingRoom readingRoom = new ReadingRoom();
        readingRoom.setLibrary(libraryService.getById(readingRoomDto.getLibraryId()));
        readingRoom.setReader(readerService.getById(readingRoomDto.getReaderId()));
        readingRoom.setResidueReader(readingRoomDto.getResidueReader());

        readingRoomRepository.save(readingRoom);
    }

    @Override
    public void delete(Long id) {

    }
}
