package ee.tasky.task_service.project.dto;

import java.util.Date;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    @Id
    private long id;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
}
