package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long apiVillageId;
    private String village;
    private String pid;
    private String fullName;
    private String guardianName;
    private String motherName;
    private String gender;
    private String maritalStatus;
    private String mobileNumber;
    private LocalDateTime dateOfBirth;

    @ManyToOne
    @JoinColumn(columnDefinition = "center_id",referencedColumnName = "id")
    private HealthCenter center;

    @OneToOne(mappedBy = "patient")
    @JoinColumn(name = "id",referencedColumnName = "patient_id")
    private PatientDetail detail;

    @OneToMany(mappedBy = "patient")
    private Set<PatientRegistration> registrations;

    @OneToMany(mappedBy = "prescriptionPatient")
    private Set<Prescription> prescriptions;



    @ManyToOne
    @JoinColumn(columnDefinition = "created_by",referencedColumnName = "id")
    private Employee createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;




}
