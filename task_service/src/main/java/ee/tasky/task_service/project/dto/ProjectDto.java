package ee.tasky.task_service.project.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto extends ProjectDataDto {
    private int id;
}


