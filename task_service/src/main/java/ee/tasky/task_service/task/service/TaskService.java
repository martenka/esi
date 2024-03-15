package main.java.ee.tasky.task_service.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esi.inventoryservice.inventory.model.InventoryItem;
import com.esi.inventoryservice.inventory.repository.InventoryRepository;

import main.java.ee.tasky.task_service.task.model.Task;
import main.java.ee.tasky.task_service.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private TaskDto mapToTaskDto(Task tas) {
        return TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .title(task.getTitle())
                .assignee(task.getAssignee())
                .priority(task.getPriority())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .created_at(task.getCreated_at())
                .modified_at(task.getModified_at())
                .project(task.getProject())
                .build();
    }

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks.stream().map(this::mapToTaskDto).toList();
    }

};
