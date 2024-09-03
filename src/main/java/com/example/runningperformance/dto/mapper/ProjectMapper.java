package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public static Project toProject(ProjectRequest projectRequest) {
        Project project = new Project();
        project.setProjectManager(projectRequest.getProjectManager());
        project.setName(projectRequest.getName());
        project.setBugdet(projectRequest.getBugdet());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        return project;
    }
}
