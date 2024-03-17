package ee.tasky.task_service.task.dto;

import java.util.Date;

import ee.tasky.task_service.task.model.Priority;
import ee.tasky.task_service.task.model.Status;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto extends TaskDataDto {

    private int id;

    private String description;
    private String title;
    private String assignee;
    private Priority priority;
    private Status status;
    private Date dueDate;

    private Date created_at;
    private Date modified_at;
}


