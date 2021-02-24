package technology.grameen.gk.health.api.entity;

import javax.persistence.*;
import java.math.BigInteger;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
