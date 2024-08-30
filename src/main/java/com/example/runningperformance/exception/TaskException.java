package com.example.runningperformance.exception;

public class TaskException extends Exception {

    public TaskException(){
        super();
    }
    public TaskException(String message){
        super(message);
    }
    public TaskException(String message, Throwable cause){
        super(message, cause);
    }
    public TaskException(Throwable cause){
        super(cause);
    }
    public TaskException(int id) {
    }
}
