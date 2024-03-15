package ee.tasky.task_service;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ee.tasky.task_service.project.model.Project;
import ee.tasky.task_service.task.model.Priority;
import ee.tasky.task_service.task.model.Status;
import ee.tasky.task_service.task.model.Task;
import ee.tasky.task_service.task.repository.TaskRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository) {
        return args -> {

            Project project1 = new Project();
            project1.setTitle("Project 1");
            project1.setDescription("Description for project 1");
            project1.setStartDate(Date.valueOf("2022-12-31"));
            project1.setEndDate(Date.valueOf("2023-12-31"));

            Task task1 = new Task();
            task1.setTitle("Task 1");
            task1.setDescription("Description for task 1");
            task1.setPriority(Priority.LOW);
            task1.setStatus(Status.OPEN);
            task1.setProject(project1);
            taskRepository.save(task1);

        };
    }

}