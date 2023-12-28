package com.keelient.springboot.tutorial.error;

import com.keelient.springboot.tutorial.entity.ErroMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErroMessage> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                   WebRequest webRequest) {
        ErroMessage erroMessage = new ErroMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroMessage);
    }
}
