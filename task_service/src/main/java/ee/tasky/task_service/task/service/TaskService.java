package ee.tasky.task_service.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ee.tasky.task_service.task.dto.TaskDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.tasky.task_service.task.dto.TaskDto;
import ee.tasky.task_service.task.model.Task;
import ee.tasky.task_service.task.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Optional<Task> getTaskById(int id) {
		return taskRepository.findById(id);
    }

    public Task createTask(TaskDto taskDto) {
        Task task = Task.builder()
                .id(taskDto.getId())
                .description(taskDto.getDescription())
                .title(taskDto.getTitle())

                .priority(taskDto.getPriority())
                .status(taskDto.getStatus())
                .dueDate(taskDto.getDueDate())
                .build();
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(int id, TaskDataDto taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setPriority(taskDetails.getPriority());
            task.setStatus(taskDetails.getStatus());
            task.setDueDate(taskDetails.getDueDate());
            return Optional.of(taskRepository.save(task));
        } else {
            return Optional.empty();
        }
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

}
