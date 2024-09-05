package com.example.runningperformance.dto.mapper;

import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.dto.response.ProjectResponse;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.exception.ProjectNotFoundException;
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
    public static ProjectResponse toProjectResponse(Project project) throws ProjectNotFoundException {

        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setProjectManager(project.getProjectManager());
        projectResponse.setName(project.getName());
        projectResponse.setBugdet(project.getBugdet());
        projectResponse.setStartDate(project.getStartDate());
        projectResponse.setEndDate(project.getEndDate());
        return projectResponse;
    }

    public static void updateProject(Project project, ProjectRequest projectRequest) throws ProjectNotFoundException {
        project.setProjectManager(projectRequest.getProjectManager());
        project.setName(projectRequest.getName());
        project.setBugdet(projectRequest.getBugdet());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
    }
}
