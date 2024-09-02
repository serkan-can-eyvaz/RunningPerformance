package com.example.runningperformance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "there is no such employee")
public class EmployeeNotFoundException extends Exception{

        public EmployeeNotFoundException(){
            super();
        }
        public EmployeeNotFoundException(String message){
            super(message);
        }
        public EmployeeNotFoundException(String message, Throwable cause){
            super(message, cause);
        }
        public EmployeeNotFoundException(Throwable cause){
            super(cause);
        }
        public EmployeeNotFoundException(int id) {
        }
}
