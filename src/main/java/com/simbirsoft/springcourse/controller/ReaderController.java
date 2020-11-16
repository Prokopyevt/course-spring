package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.service.LibraryService;
import com.simbirsoft.springcourse.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable("id") Long id){
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
      Reader reader = readerService.getById(id);

        if (isEmpty(reader)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reader);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addlibrary( @RequestBody ReaderDto readerDto ){
        if (isEmpty(readerDto)) {
            return ResponseEntity.badRequest().build();
        }

        readerService.save(readerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Reader reader = readerService.getById(id);
        if(isEmpty(reader)) {
            return  ResponseEntity.notFound().build();
        }
        readerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
