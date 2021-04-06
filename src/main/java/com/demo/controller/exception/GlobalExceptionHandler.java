package com.demo.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request) {
        log.info("SQLException Occured::URL=" + request.getRequestURL());
        return "error";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException")
    @ExceptionHandler(IOException.class)
    public String handleIOException() {
        log.error("IOException handler executed");
        return "error";

    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "IOError")
    @ExceptionHandler(IOError.class)
    public String HandleIOException() {
        log.error("IOError handler executed");
        return "error";
    }

}
