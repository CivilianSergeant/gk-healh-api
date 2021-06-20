package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_logs")
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    private Boolean status;
    private String note;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
