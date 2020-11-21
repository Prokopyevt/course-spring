package com.simbirsoft.springcourse.service.MistakesController;

import com.simbirsoft.springcourse.repository.ReaderRepository;
import org.apache.tomcat.jni.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorChecking extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ThereIsNoSuchUserException.class)

   public ResponseEntity<String> handleThereIsNoSuchUserException(ThereIsNoSuchUserException e) {
        return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}


