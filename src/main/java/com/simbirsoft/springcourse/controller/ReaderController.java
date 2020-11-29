package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.service.ReaderService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/reader")
@AllArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @ApiParam(value = "Введите необходимый ID")
    @PreAuthorize("hasAnyAuthority('READER_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(readerService.getById(id));
    }

    @ApiParam(value = "Введите дату рождения и имя читателя")
    @PreAuthorize("hasAuthority('READER_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Reader> addReader(@RequestBody ReaderDto readerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(readerDto));
    }

    @ApiParam(value = "Введите ID, который необходимо удалить")
    @PreAuthorize("hasAuthority('READER_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        readerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
