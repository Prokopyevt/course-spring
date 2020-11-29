package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.service.ReadingRoomService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/readingRoom")
@AllArgsConstructor
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;

    @ApiParam(value = "Введите необходимый ID")
    @PreAuthorize("hasAnyAuthority('READINGROOM_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<ReadingRoom> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(readingRoomService.getById(id));
    }

    @ApiParam(value = "Введите необходимый ID читателя и ID библиотеки, а также количество оставшихся читателей")
    @PreAuthorize("hasAuthority('READINGROOM_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<ReadingRoom> addReadingRoom(@RequestBody ReadingRoomDto readingRoomDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readingRoomService.save(readingRoomDto));
    }

    @ApiParam(value = "Введите ID, который необходимо удалить")
    @PreAuthorize("hasAuthority('READINGROOM_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        readingRoomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
