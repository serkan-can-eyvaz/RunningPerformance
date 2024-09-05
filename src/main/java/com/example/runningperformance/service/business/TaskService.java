package com.example.runningperformance.service.business;

import com.example.runningperformance.dao.EmployeeRepository;
import com.example.runningperformance.dao.ProjectRepository;
import com.example.runningperformance.dao.TaskRepository;
import com.example.runningperformance.dto.mapper.EmployeeMapper;
import com.example.runningperformance.dto.mapper.ProjectMapper;
import com.example.runningperformance.dto.mapper.TaskMapper;
import com.example.runningperformance.dto.request.TaskRequest;
import com.example.runningperformance.dto.response.TaskResponse;
import com.example.runningperformance.dto.response.TaskWithEmployeeAndProjectRespons;
import com.example.runningperformance.entity.Employee;
import com.example.runningperformance.entity.Project;
import com.example.runningperformance.entity.Task;
import com.example.runningperformance.exception.EmployeeNotFoundException;
import com.example.runningperformance.exception.ProjectNotFoundException;
import com.example.runningperformance.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService implements com.example.runningperformance.service.Abstract.TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.taskMapper = taskMapper;
    }

    public Task createTask(TaskRequest taskRequest) throws TaskNotFoundException, EmployeeNotFoundException, ProjectNotFoundException {

        Employee employee = employeeRepository.findById(taskRequest.getEmployeeId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id not found" + taskRequest.getEmployeeId()));

        Optional<Project> optionalproject = projectRepository.findById(taskRequest.getProjectId());
        if (!optionalproject.isPresent()) {
            throw new ProjectNotFoundException("Project id not found" + taskRequest.getProjectId());
        }
        Project project = optionalproject.get();

        Task task = taskMapper.toTask(taskRequest);

        employee.addTask(task);
        project.addTask(task);

        return taskRepository.save(task);
    }

    @Override
    public TaskWithEmployeeAndProjectRespons findTaskById(Long id) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {

        Optional<Task> optionaltask = taskRepository.findById(id);
        if (!optionaltask.isPresent()) {
            throw new TaskNotFoundException("Task id not found" + id);
        }
        Task task = optionaltask.get();
        TaskWithEmployeeAndProjectRespons taskResponse = taskMapper.toTaskWithEmployeeAndProjectRespons(task);

        taskResponse.setEmployeeResponse(EmployeeMapper.toEmployeeResponse(task.getEmployee()));
        taskResponse.setProjectResponse(ProjectMapper.toProjectResponse(task.getProject()));

        return taskResponse;
    }

    @Override
    public List<TaskResponse> findAllTasks() throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(task ->
                {
                    try {
                        return taskMapper.toTaskResponse(task);
                    } catch (TaskNotFoundException e) {
                        throw new RuntimeException("list is empty");
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTaskById(Long id) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {
        Task task =taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task id not found" + id));
        taskRepository.delete(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) throws EmployeeNotFoundException, TaskNotFoundException, ProjectNotFoundException {

        Task task = taskRepository.findById(id).orElseThrow(() ->
                new TaskNotFoundException("Task id not found"));

        TaskMapper.updateTask(task,taskRequest);

        return taskMapper.toTaskResponse(task);
        //projecet id ve employee id değişikliği eklenebilir daha kullanıcı dostu bir işlem..

     }


}
