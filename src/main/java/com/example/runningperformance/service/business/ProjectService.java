package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.ProjectMapper;
import com.example.runningperformance.dto.request.ProjectRequest;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import com.example.runningperformance.service.Abstract.ProjecetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjecetService {

    private  final ProjectRepository projectRepository;
    private  final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository,TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
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
}
