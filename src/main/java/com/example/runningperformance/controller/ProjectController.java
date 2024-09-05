package com.example.runningperformance.controller;

import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.dto.response.ProjectResponse;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.business.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @PostMapping
    public Project createProject(@RequestBody ProjectRequest projectRequest) throws TaskNotFoundException, ProjectNotFoundException {
        return projectService.createProject(projectRequest);
    }
    @GetMapping()
    public List<ProjectResponse> getAllProjects() throws TaskNotFoundException, ProjectNotFoundException {
        return projectService.getAllProjects();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProjectResponse getProjectById(@PathVariable Long id) throws TaskNotFoundException, ProjectNotFoundException {

       Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
       return projectService.getProjectById(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteProjectById(@PathVariable Long id) throws TaskNotFoundException, ProjectNotFoundException {

        Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
        projectService.deleteProjectById(id);
    }
    @PutMapping()
    public ProjectResponse updateProject(@PathVariable long id, ProjectRequest projectRequest) throws TaskNotFoundException, ProjectNotFoundException {

        return projectService.updateProjectById(id,projectRequest);
    }

}
