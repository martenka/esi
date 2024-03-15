package main.java.ee.tasky.task_service.task.model;

import java.util.Date;

@Entity
@Table(name = "project")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;

}