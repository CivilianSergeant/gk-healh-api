package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lab_test_units")
public class LabTestUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "labTestUnit")
    private Set<LabTestAttribute> labTestAttributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonBackReference
    @JsonIgnore
    public Set<LabTestAttribute> getLabTestAttributes() {
        return this.labTestAttributes;
    }

    @JsonBackReference
    public void addLabTestAttribute(LabTestAttribute labTestAttribute) {
        if(labTestAttribute != null){
            if(this.labTestAttributes == null){
                this.labTestAttributes = new HashSet<>();
            }
            labTestAttribute.setLabTestUnit(this);
            this.labTestAttributes.add(labTestAttribute);
        }

    }

    public void setNullAttributes(){
        this.labTestAttributes = new HashSet<>();
    }
}
