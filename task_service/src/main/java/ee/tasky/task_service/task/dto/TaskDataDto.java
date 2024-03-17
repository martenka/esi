package ee.tasky.task_service.task.dto;

import ee.tasky.task_service.task.model.Priority;
import ee.tasky.task_service.task.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDataDto {
	private String description;
	private String title;
	private String assignee;
	private Priority priority;
	private Status status;
	private Date dueDate;

	private Date created_at;
	private Date modified_at;
}
