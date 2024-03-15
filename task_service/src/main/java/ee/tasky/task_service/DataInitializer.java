package ee.tasky.task_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ee.tasky.task_service.task.model.Priority;
import ee.tasky.task_service.task.model.Status;
import ee.tasky.task_service.task.model.Task;
import ee.tasky.task_service.task.repository.TaskRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository) {
        return args -> {

            Task task1 = new Task();
            task1.setTitle("Task 1");
            task1.setDescription("Description for task 1");
            task1.setPriority(Priority.LOW);
            task1.setStatus(Status.OPEN);
            taskRepository.save(task1);

        };
    }

}