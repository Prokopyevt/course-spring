package com.simbirsoft.springcourse.controller;


import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {


    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PreAuthorize("hasAnyAuthority('LIBRARY_READ,')")
    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(libraryService.getById(id));
    }
    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Library> addLibrary(@RequestBody LibraryDto libraryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.save(libraryDto));
    }

    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        libraryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
