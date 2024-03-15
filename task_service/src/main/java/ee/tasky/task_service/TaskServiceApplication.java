package ee.tasky.task_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {
		DatabaseInitializer.initialize("taskservice_db");

		SpringApplication.run(TaskServiceApplication.class, args);
	}

}
