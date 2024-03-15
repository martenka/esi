package ee.tasky.task_service.project.repository;

import org.springframework.data.repository.CrudRepository;

import ee.tasky.task_service.project.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
