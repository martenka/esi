package ee.tasky.task_service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDataDto {
	private String title;
	private String description;
	private Date startDate;
	private Date endDate;

	private Date createdAt;
	private Date updatedAt;
}
