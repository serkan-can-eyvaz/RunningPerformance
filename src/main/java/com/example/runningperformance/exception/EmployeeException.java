package com.example.runningperformance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "there is no such employee")
public class EmployeeException extends Exception{

        public EmployeeException(){
            super();
        }
        public EmployeeException(String message){
            super(message);
        }
        public EmployeeException(String message, Throwable cause){
            super(message, cause);
        }
        public EmployeeException(Throwable cause){
            super(cause);
        }
        public EmployeeException(int id) {
        }
}
