package ee.tasky.task_service.project.controller;

import ee.tasky.task_service.project.dto.ProjectDataDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

import ee.tasky.task_service.project.dto.ProjectDto;
import ee.tasky.task_service.project.model.Project;
import ee.tasky.task_service.project.service.ProjectService;

@RestController
@NoArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    private ProjectDto mapToProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .description(project.getDescription())
                .title(project.getTitle())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())

                .build();
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects().stream().map(this::mapToProjectDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable int id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(p -> ResponseEntity.ok(mapToProjectDto(p)))
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        return mapToProjectDto(projectService.createProject(projectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable int id, @RequestBody ProjectDataDto projectDetails) {
        Optional<Project> updatedProject = projectService.updateProject(id, projectDetails);

		return updatedProject.map(value -> ResponseEntity.ok(mapToProjectDto(value)))
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}