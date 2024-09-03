package com.example.runningperformance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "there is so such project")
public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException() {
        super();
    }
    public ProjectNotFoundException(String message) {
        super(message);
    }
    public ProjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProjectNotFoundException(Throwable cause) {

    }
    public ProjectNotFoundException(int id) {

    }
}
