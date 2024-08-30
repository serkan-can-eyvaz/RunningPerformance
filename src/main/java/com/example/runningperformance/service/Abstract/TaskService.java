package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.entity.Task;

public interface TaskService  {
    Task createTask(TaskRequest taskRequest) throws Exception;
}
