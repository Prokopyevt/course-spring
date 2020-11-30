package com.simbirsoft.springcourse.controller;

import com.simbirsoft.springcourse.dto.ReadingRoomDto;
import com.simbirsoft.springcourse.model.ReadingRoom;
import com.simbirsoft.springcourse.service.ReadingRoomService;
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
@RequestMapping("/api/v1/readingRoom")
@AllArgsConstructor
public class ReadingRoomController {

    private final ReadingRoomService readingRoomService;

    @ApiOperation(value = "Введите необходимый ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено")
    })
    @PreAuthorize("hasAnyAuthority('READINGROOM_READ')")
    @GetMapping("/{id}")
    public ResponseEntity<ReadingRoom> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(readingRoomService.getById(id));
    }

    @ApiOperation(value = "Введите необходимый ID читателя и ID библиотеки, а также количество оставшихся читателей")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 404, message = "Не найдено"),
                           @ApiResponse(code = 201, message = "Создано")})
    @PreAuthorize("hasAuthority('READINGROOM_WRITE')")
    @PostMapping("/create")
    public ResponseEntity<ReadingRoom> addReadingRoom(@RequestBody ReadingRoomDto readingRoomDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(readingRoomService.save(readingRoomDto));
    }

    @ApiOperation(value = "Введите ID, который необходимо удалить")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Запрос успешно выполнен"),
                           @ApiResponse(code = 403, message = "Данное действие запрещено"),
                           @ApiResponse(code = 401, message = "Вы не авторизованы"),
                           @ApiResponse(code = 204, message = "Контент отсутствует")})
    @PreAuthorize("hasAuthority('READINGROOM_WRITE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        readingRoomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
