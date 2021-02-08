package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_registrations")
public class PatientRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    private String cardNumber;
    private Boolean isGB;
    private LocalDateTime startDate;
    private LocalDateTime expiredDate;
    private Boolean isActive;
    private Boolean isCardReceived;
    private LocalDateTime cardReceivedDate;
    private int totalServiceTaken;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;
}
