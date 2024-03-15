package main.java.ee.tasky.task_service.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

enum Priority {
    LOW, MEDIUM, HIGH
}

enum Status {
    OPEN, IN_PROGRESS, ON_HOLD, DONE, CLOSED
}

@Entity
@Table(name = "tasktable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String title;

    // @ManyToOne
    // private User assignee;
    private Priority priority;
    private Status status;
    private Date dueDate;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @ManyToOne
    private Project project;

}
