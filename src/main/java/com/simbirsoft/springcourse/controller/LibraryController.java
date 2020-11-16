package com.simbirsoft.springcourse.controller;


import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable("id") Long id){
    if (isEmpty(id)) {
        return ResponseEntity.badRequest().build();
    }
    Library library = libraryService.getById(id);

    if (isEmpty(library)) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(library);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addlibrary( @RequestBody LibraryDto libraryDto ){
        if (isEmpty(libraryDto)) {
    return ResponseEntity.badRequest().build();
    }

libraryService.save(libraryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
    }
        Library library = libraryService.getById(id);
        if(isEmpty(library)) {
        return  ResponseEntity.notFound().build();
        }
        libraryService.delete(id);
        return ResponseEntity.ok().build();
        }
}
