package com.simbirsoft.springcourse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/Message")
    public ResponseEntity<String> newMessage() {
        return new ResponseEntity<>("New Message", HttpStatus.OK);
    }
}
