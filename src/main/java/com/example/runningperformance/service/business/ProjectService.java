package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.ProjectMapper;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.dto.response.ProjectResponse;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.Abstract.ProjecetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService implements ProjecetService {

    private  final ProjectRepository projectRepository;
    private  final TaskRepository taskRepository;
    private  final ProjectMapper projectMapper;
    private  final TaskMapper taskMapper;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository, ProjectMapper projectMapper, TaskMapper taskMapper) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.projectMapper = projectMapper;
        this.taskMapper = taskMapper;
    }


    @Override
    public Project createProject(ProjectRequest projectRequest) throws ProjectNotFoundException ,TaskNotFoundException {

        Project project = ProjectMapper.toProject(projectRequest);

        List<Long> taskIds = projectRequest.getTaskIds();

        List<Task> tasks = new ArrayList<>();
        for (Long taskId : taskIds) {
            Optional<Task> taskOptional = taskRepository.findById(taskId);
            if (taskOptional.isPresent()) {
                Task task = taskOptional.get();
                tasks.add(task);
            }
            else
                throw new TaskNotFoundException("Task ıd not found with id : "+taskId);

        }
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectResponse> getAllProjects() throws ProjectNotFoundException, TaskNotFoundException{
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(project ->
                {
                        try {
                            return projectMapper.toProjectResponse(project);
                        }catch (ProjectNotFoundException e)
                        {
                            throw  new RuntimeException("Project not found");
                        }

                }).collect(Collectors.toList());

    }

    @Override
    public ProjectResponse getProjectById(Long id) throws ProjectNotFoundException {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        ProjectResponse projectResponse =ProjectMapper.toProjectResponse(project);

        List<TaskResponse> taskResponses = project.getProjectTasks().stream()
                .map(task -> {
                    try {
                        return taskMapper.toTaskResponse(task);
                    } catch (TaskNotFoundException e) {
                        throw new RuntimeException("registered task not found"); // veya uygun bir işleme yapılabilir
                    }
                })
                .collect(Collectors.toList());

        projectResponse.setTasks(taskResponses);
        return projectResponse;
    }

    @Override
    public void deleteProjectById(Long id) throws ProjectNotFoundException {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        projectRepository.delete(project);
    }

    @Override
    public ProjectResponse updateProjectById(Long id, ProjectRequest projectRequest) throws ProjectNotFoundException,TaskNotFoundException {

        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        ProjectMapper.updateProject(project, projectRequest);

        List<Long> taskIds = projectRequest.getTaskIds();
        List<Task> newTask = new ArrayList<>();

        for (Long taskId : taskIds) {
            Optional<Task> taskOptional = taskRepository.findById(taskId);
            if (taskOptional.isPresent()) {
                Task task = taskOptional.get();
                newTask.add(task);
            }
            else {
                throw new TaskNotFoundException("Task not found");
            }
        }

        project.getProjectTasks().clear();
        for (Task task : newTask) {
            project.addTask(task);
        }

        projectRepository.save(project);
        return ProjectMapper.toProjectResponse(project);
    }


}
