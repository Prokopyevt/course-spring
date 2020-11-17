package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/readingRoom")
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;

    public ReadingRoomController(ReadingRoomService readingRoomService) {
        this.readingRoomService = readingRoomService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingRoom> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(readingRoomService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ReadingRoom> addReadingRoom(@RequestBody ReadingRoomDto readingRoomDto ){
        return ResponseEntity.status(HttpStatus.CREATED).body(readingRoomService.save(readingRoomDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
         readingRoomService.delete(id);
             return ResponseEntity.ok().build();
    }
}
