package main.java.ee.tasky.task_service.task.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.ee.tasky.task_service.task.model.Project;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @Id
    private long id;

    private String description;
    private String title;
    private String assignee;
    private Priority priority;
    private Status status;
    private Date dueDate;

    private Date created_at;
    private Date modified_at;

    private Project project;
}
