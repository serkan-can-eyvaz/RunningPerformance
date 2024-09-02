package com.example.runningperformance.exception;

public class TaskNotFoundException extends Exception {

    public TaskNotFoundException(){
        super();
    }
    public TaskNotFoundException(String message){
        super(message);
    }
    public TaskNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public TaskNotFoundException(Throwable cause){
        super(cause);
    }
    public TaskNotFoundException(int id) {
    }
}
