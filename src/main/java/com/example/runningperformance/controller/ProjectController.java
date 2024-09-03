package com.example.runningperformance.controller;

import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.business.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectRequest projectRequest) throws TaskNotFoundException, ProjectNotFoundException {
        return projectService.createProject(projectRequest);
    }
}
