package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.service.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
@RequestMapping("/api/v1/reader")
public class ReaderController {


    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PreAuthorize("hasAnyAuthority('READER_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(readerService.getById(id));
    }

    @PreAuthorize("hasAuthority('READER_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Reader> addReader(@RequestBody ReaderDto readerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(readerDto));
    }

    @PreAuthorize("hasAuthority('READER_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        readerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
