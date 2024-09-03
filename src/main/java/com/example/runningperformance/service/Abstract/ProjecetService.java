package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;

public interface ProjecetService {

    Project createProject(ProjectRequest projectRequest) throws ProjectNotFoundException, TaskNotFoundException;
}
