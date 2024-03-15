package ee.tasky.task_service.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.tasky.task_service.project.dto.ProjectDto;
import ee.tasky.task_service.project.model.Project;
import ee.tasky.task_service.project.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private ProjectDto mapToProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .description(project.getDescription())
                .title(project.getTitle())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())

                .build();
    }

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects.stream().map(this::mapToProjectDto).toList();
    }

};
