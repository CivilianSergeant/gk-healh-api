package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "lab_test_details")
public class LabTestDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_test_id",referencedColumnName = "id")
    private LabTest labTest;

    @ManyToOne
    private LabTestAttribute labTestAttribute;

    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public LabTestAttribute getLabTestAttribute() {
        return labTestAttribute;
    }

    public void setLabTestAttribute(LabTestAttribute labTestAttribute) {
        this.labTestAttribute = labTestAttribute;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
