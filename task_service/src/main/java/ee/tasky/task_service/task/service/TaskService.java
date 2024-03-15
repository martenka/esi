package ee.tasky.task_service.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.tasky.task_service.task.dto.TaskDto;
import ee.tasky.task_service.task.model.Task;
import ee.tasky.task_service.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private TaskDto mapToTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .title(task.getTitle())
                .priority(task.getPriority())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .created_at(task.getCreatedAt())
                .modified_at(task.getModifiedAt())
                .project(task.getProject())
                .build();
    }

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks.stream().map(this::mapToTaskDto).toList();
    }

};
