package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
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

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnore
    private Set<Prescription> prescribes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiEmployeeId() {
        return apiEmployeeId;
    }

    public void setApiEmployeeId(Long apiEmployeeId) {
        this.apiEmployeeId = apiEmployeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HealthCenter getCenter() {
        return center;
    }

    public void setCenter(HealthCenter center) {
        this.center = center;
    }

    @JsonBackReference
    public Set<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        if(patient != null){
            if(this.patients == null){
                this.patients = new HashSet<>();
            }
            patient.setCreatedBy(this);
            this.patients.add(patient);
        }
    }

    @JsonBackReference
    @JsonIgnore
    public Set<Prescription> getPrescribes() {
        return prescribes;
    }

    public void setPrescribes(Set<Prescription> prescribes) {
        this.prescribes = prescribes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
