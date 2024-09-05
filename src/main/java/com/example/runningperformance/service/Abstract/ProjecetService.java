package com.example.runningperformance.service.Abstract;

import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.dto.response.ProjectResponse;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;

import java.util.List;

public interface ProjecetService {

    Project createProject(ProjectRequest projectRequest) throws ProjectNotFoundException, TaskNotFoundException;
    List<ProjectResponse> getAllProjects() throws ProjectNotFoundException, TaskNotFoundException ;
    ProjectResponse getProjectById(Long id) throws ProjectNotFoundException;
    void deleteProjectById(Long id) throws ProjectNotFoundException;
    ProjectResponse updateProjectById(Long id, ProjectRequest projectRequest) throws ProjectNotFoundException,TaskNotFoundException;
}
