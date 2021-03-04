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
@NamedEntityGraph(name="pid",attributeNodes = {
        @NamedAttributeNode(value = "center"),
        @NamedAttributeNode(value = "createdBy"),
        @NamedAttributeNode(value = "detail"),
        @NamedAttributeNode(value = "registrations",subgraph = "members"),
        @NamedAttributeNode(value = "prescriptions"),
        @NamedAttributeNode(value = "patientInvoices",subgraph = "patientInvoices"),

}, subgraphs = {
    @NamedSubgraph(name = "patientInvoices",attributeNodes = {
        @NamedAttributeNode(value = "patientServiceDetails",subgraph = "patientServiceDetails")
    }),
    @NamedSubgraph(name = "patientServiceDetails",attributeNodes = {
            @NamedAttributeNode(value = "service",subgraph = "service")
    }),
    @NamedSubgraph(name = "members",attributeNodes = {
        @NamedAttributeNode("members")
    }),
    @NamedSubgraph(name = "service",attributeNodes = {
            @NamedAttributeNode(value = "serviceCategory"),
            @NamedAttributeNode(value = "labTestGroup")
    })
})
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
    private PatientDetail detail;

    @OneToMany(mappedBy = "patient")
    private Set<CardRegistration> registrations;

    @OneToMany(mappedBy = "prescriptionPatient")
    private Set<Prescription> prescriptions;

    @OneToMany(mappedBy = "patient")
    private Set<PatientInvoice> patientInvoices;

    @OneToMany(mappedBy = "patient")
    private Set<LabTest> labTests;


    @ManyToOne
    @JoinColumn(columnDefinition = "created_by",referencedColumnName = "id")
    private Employee createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public Patient() {

    }

    public Patient(Long id) {
        this.id = id;
    }

    public Patient(Long id, String pid, String fullName, String gender, String maritalStatus,
                   LocalDateTime dateOfBirth, HealthCenter center, String guardianName,
                   LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.id = id;
        this.pid = pid;
        this.fullName = fullName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.dateOfBirth = dateOfBirth;
        this.center = center;
        this.guardianName = guardianName;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiVillageId() {
        return apiVillageId;
    }

    public void setApiVillageId(Long apiVillageId) {
        this.apiVillageId = apiVillageId;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public HealthCenter getCenter() {
        return center;
    }

    public void setCenter(HealthCenter center) {
        this.center = center;
    }

    public PatientDetail getDetail() {
        return detail;
    }

    public void setDetail(PatientDetail detail) {
        this.detail = detail;
    }


    public Set<CardRegistration> getRegistrations() {
        return registrations;
    }

    public void addRegistration(CardRegistration registration) {
        if(registration != null){
            if(this.registrations == null){
                this.registrations = new HashSet<>();
            }
            registration.setPatient(this);
            this.registrations.add(registration);
        }

    }


    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<PatientInvoice> getPatientInvoices() {
        return patientInvoices;
    }

    public void addPatientInvoices(PatientInvoice patientInvoice) {
        if(patientInvoice != null){
            if(this.patientInvoices == null){
                this.patientInvoices = new HashSet<>();
            }
            patientInvoice.setPatient(this);
            this.patientInvoices.add(patientInvoice);
        }
    }




    public Employee getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
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
