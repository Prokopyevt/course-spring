package com.simbirsoft.springcourse.controller;


import com.simbirsoft.springcourse.dto.LibraryDto;
import com.simbirsoft.springcourse.model.Library;
import com.simbirsoft.springcourse.service.LibraryService;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "Введите необходимый ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено")})
    @PreAuthorize("hasAnyAuthority('LIBRARY_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Library> getById (@PathVariable("id") Long id)   {

        return ResponseEntity.ok(libraryService.getById(id));
    }

    @ApiOperation(value = "Введите автора, название книги, статус библиотеки и год издания книги")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено"),
                           @ApiResponse(code = 201, message = "Создано")})
    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Library> addLibrary(@RequestBody LibraryDto libraryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.save(libraryDto));
    }
    @ApiOperation(value = "Введите ID библиотеки, который необходимо удалить")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 204, message = "Контент отсутствует")})
    @PreAuthorize("hasAuthority('LIBRARY_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        libraryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
