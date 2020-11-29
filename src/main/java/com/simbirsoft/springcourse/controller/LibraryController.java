package com.simbirsoft.springcourse.controller;


import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.service.LibraryService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/library")
@AllArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @ApiParam(value = "Введите необходимый ID")
    @PreAuthorize("hasAnyAuthority('LIBRARY_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(libraryService.getById(id));
    }

    @ApiParam(value = "Введите автора, название книги, статус библиотеки и год издания книги")
    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Library> addLibrary(@RequestBody LibraryDto libraryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.save(libraryDto));
    }
    @ApiParam(value = "Введите ID библиотеки, который необходимо удалить")
    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        libraryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
