package ee.tasky.task_service.task.repository;

import org.springframework.data.repository.CrudRepository;

import ee.tasky.task_service.task.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
