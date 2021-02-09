package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Patient prescriptionPatient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Employee doctor;

    @ManyToOne
    private HealthCenter center;

    private String pNumber;
    private LocalDateTime visitDate;
    private LocalDateTime nextVisitDate;

    private String complain;
    private String symptoms;
    private String diagnosis;
    private Boolean isNew;
    private String advice;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;



}
