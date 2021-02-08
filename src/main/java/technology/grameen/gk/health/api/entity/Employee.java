package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long apiEmployeeId;
    private String fullName;
    private String designation;
    private String contactNumber;
    private String email;

    @ManyToOne
    private HealthCenter center;

    @OneToMany(mappedBy = "createdBy")
    private Set<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private Set<Prescription> prescribes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;
}
