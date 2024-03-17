package ee.tasky.task_service.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ee.tasky.task_service.project.dto.ProjectDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.tasky.task_service.project.dto.ProjectDto;
import ee.tasky.task_service.project.model.Project;
import ee.tasky.task_service.project.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects.stream().toList();
    }

    public Optional<Project> getProjectById(int id) {
		return projectRepository.findById(id);
    }

    public Project createProject(ProjectDto projectDto) {
        Project project = Project.builder()
                .id(projectDto.getId())
                .description(projectDto.getDescription())
                .title(projectDto.getTitle())
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .build();
        return projectRepository.save(project);
    }

    public Optional<Project> updateProject(int id, ProjectDataDto projectDetails) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setDescription(projectDetails.getDescription());
            project.setTitle(project.getTitle());
            project.setStartDate(projectDetails.getStartDate());
            project.setEndDate(projectDetails.getEndDate());
            return Optional.of(projectRepository.save(project));
        } else {
            return Optional.empty();
        }
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
