package com.simbirsoft.springcourse.service.Impl;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.repository.ReadingRoomRepository;
import com.simbirsoft.springcourse.service.LibraryService;
import com.simbirsoft.springcourse.service.ReaderService;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class ReadingRoomImpl implements ReadingRoomService {


    private final ReadingRoomRepository readingRoomRepository;
    private final LibraryService libraryService;
    private final ReaderService readerService;


    public ReadingRoomImpl(ReadingRoomRepository readingRoomRepository, LibraryService libraryService, ReaderService readerService) {
        this.readingRoomRepository = readingRoomRepository;
        this.libraryService = libraryService;
        this.readerService = readerService;
    }


    @Override
    public ReadingRoom getById(Long id)  {
        if(isEmpty(id)) {
            throw new NullPointerException("Пусто");
        }
        ReadingRoom readingRoom = readingRoomRepository.findById(id).orElse(null);
        if(isEmpty(readingRoom)){
            throw new NullPointerException("Пусто");
        }
             return  readingRoom;
    }

    @Override
    public ReadingRoom save(ReadingRoomDto readingRoomDto) {
        if(isEmpty(readingRoomDto)){
            throw new NullPointerException("Пусто");
        }
        ReadingRoom readingRoom = new ReadingRoom();
        readingRoom.setLibrary(libraryService.getById(readingRoomDto.getLibraryId()));
        readingRoom.setReader(readerService.getById(readingRoomDto.getReaderId()));
        readingRoom.setResidueReader(readingRoomDto.getResidueReader());
            return readingRoomRepository.save(readingRoom);
    }

    @Override
    public void delete(Long id) {
        readingRoomRepository.delete(getById(id));
    }
}
