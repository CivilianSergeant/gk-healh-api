package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "lab_test_attributes")
public class LabTestAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lab_test_unit_id",referencedColumnName = "id")
    private LabTestUnit labTestUnit;

    private String attributeName;
    private String averageRange;
    private String maleRange;
    private String femaleRange;
    private String childRange;
    private Integer displayOrder;
    private Boolean isActive;

    private Boolean isGroup;

    @OneToMany(mappedBy = "labTestAttribute")
    private Set<LabTestDetail> labTestDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    @JsonIgnore
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAverageRange() {
        return averageRange;
    }

    public void setAverageRange(String averageRange) {
        this.averageRange = averageRange;
    }

    public String getMaleRange() {
        return maleRange;
    }

    public void setMaleRange(String maleRange) {
        this.maleRange = maleRange;
    }

    public String getFemaleRange() {
        return femaleRange;
    }

    public void setFemaleRange(String femaleRange) {
        this.femaleRange = femaleRange;
    }

    public String getChildRange() {
        return childRange;
    }

    public void setChildRange(String childRange) {
        this.childRange = childRange;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getGroup() {
        return isGroup;
    }

    public void setGroup(Boolean group) {
        isGroup = group;
    }

    @JsonManagedReference
    public LabTestUnit getLabTestUnit() {
        return labTestUnit;
    }

    public void setLabTestUnit(LabTestUnit labTestUnit) {
        this.labTestUnit = labTestUnit;
    }

    public Set<LabTestDetail> getLabTestDetail() {
        return labTestDetails;
    }

    public void addLabTestDetail(LabTestDetail labTestDetail) {
        if(labTestDetail != null){
            if(this.labTestDetails == null){
                labTestDetail.setLabTestAttribute(this);
                this.labTestDetails.add(labTestDetail);
            }
        }
    }
}
