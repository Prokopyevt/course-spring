package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReaderDto;
import com.simbirsoft.springcourse.model.Reader;
import com.simbirsoft.springcourse.service.ReaderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Введите необходимый ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено")})
    @PreAuthorize("hasAnyAuthority('READER_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(readerService.getById(id));
    }

    @ApiOperation(value = "Введите дату рождения и имя читателя")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено"),
                           @ApiResponse(code = 201, message = "Создано")})
    @PreAuthorize("hasAuthority('READER_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<Reader> addReader(@RequestBody ReaderDto readerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(readerDto));
    }

    @ApiOperation(value = "Введите ID, который необходимо удалить")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 204, message = "Контент отсутствует")})
    @PreAuthorize("hasAuthority('READER_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        readerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
