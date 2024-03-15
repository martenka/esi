package ee.tasky.task_service.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

                .build();
    }

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks.stream().map(this::mapToTaskDto).toList();
    }

    public Optional<TaskDto> getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return Optional.of(mapToTaskDto(task.get()));
        } else {
            return Optional.empty();
        }
    }

    @SuppressWarnings("null")
    public TaskDto createTask(TaskDto taskDto) {
        Task task = Task.builder()
                .id(taskDto.getId())
                .description(taskDto.getDescription())
                .title(taskDto.getTitle())

                .priority(taskDto.getPriority())
                .status(taskDto.getStatus())
                .dueDate(taskDto.getDueDate())
                .build();
        return mapToTaskDto(taskRepository.save(task));
    }

    public Optional<TaskDto> updateTask(int id, TaskDto taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setPriority(taskDetails.getPriority());
            task.setStatus(taskDetails.getStatus());
            task.setDueDate(taskDetails.getDueDate());
            return Optional.of(mapToTaskDto(taskRepository.save(task)));
        } else {
            return Optional.empty();
        }
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

};
