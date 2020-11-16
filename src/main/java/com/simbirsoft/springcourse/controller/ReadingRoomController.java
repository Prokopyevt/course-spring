package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/readingRoom")
public class ReadingRoomController {
    @Autowired
    private ReadingRoomService readingRoomService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadingRoom> getById(@PathVariable("id") Long id){
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        ReadingRoom readingRoom = readingRoomService.getById(id);

        if (isEmpty(readingRoom)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(readingRoom);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addreadingRoom(@RequestBody ReadingRoomDto readingRoomDto ){
        if (isEmpty(readingRoomDto)) {
            return ResponseEntity.badRequest().build();
        }

        readingRoomService.save(readingRoomDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        ReadingRoom readingRoom = readingRoomService.getById(id);
        if(isEmpty(readingRoom)) {
            return  ResponseEntity.notFound().build();
        }
      readingRoomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
