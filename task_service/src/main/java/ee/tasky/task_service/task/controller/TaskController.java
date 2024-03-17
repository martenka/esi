package ee.tasky.task_service.task.controller;

import java.util.List;

import ee.tasky.task_service.task.dto.TaskDataDto;
import ee.tasky.task_service.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.tasky.task_service.task.dto.TaskDto;
import ee.tasky.task_service.task.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    public TaskController() {
    }

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

                .build();
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks().stream().map(this::mapToTaskDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id).map(t -> ResponseEntity.ok(mapToTaskDto(t))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return mapToTaskDto(taskService.createTask(taskDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id, @RequestBody TaskDataDto taskDetails) {
        return taskService.updateTask(id, taskDetails).map(t -> ResponseEntity.ok(mapToTaskDto(t)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();

    }

}