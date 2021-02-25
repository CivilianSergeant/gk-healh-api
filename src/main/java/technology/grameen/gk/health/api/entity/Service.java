package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "serviceCategoryId",referencedColumnName = "id")
    private ServiceCategory serviceCategory;

    @OneToMany(mappedBy = "service")
    private Set<PatientService> patientServices;

    @OneToMany(mappedBy = "service")
    private Set<LabTestAttribute> labTestAttributes;

    @OneToMany(mappedBy = "service")
    private Set<LabTestDetail> labTestDetails;

    @ManyToOne(optional = true)
    private LabTestGroup labTestGroup;

    private String name;

    private String code;
    private BigDecimal currentCost;
    private BigDecimal currentGbCost;
    private String description;
    private Boolean isActive;
    private Boolean isLabTest;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(BigDecimal currentCost) {
        this.currentCost = currentCost;
    }

    public BigDecimal getCurrentGbCost() {
        return currentGbCost;
    }

    public void setCurrentGbCost(BigDecimal currentGbCost) {
        this.currentGbCost = currentGbCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean isLabTest() {
        return isLabTest;
    }

    public void setLabTest(Boolean labTest) {
        this.isLabTest = labTest;
    }


    public LabTestGroup getLabTestGroup() {
        return labTestGroup;
    }

    public void setLabTestGroup(LabTestGroup labTestGroup) {
        this.labTestGroup = labTestGroup;
    }

    @JsonBackReference
    @JsonIgnore
    public Set<PatientService> getPatientServices() {
        return patientServices;
    }

    public void addPatientService(PatientService patientService) {

        if(patientService != null){
            if(this.patientServices == null){
                this.patientServices = new HashSet<>();
            }
            patientService.setService(this);
            this.patientServices.add(patientService);
        }
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
