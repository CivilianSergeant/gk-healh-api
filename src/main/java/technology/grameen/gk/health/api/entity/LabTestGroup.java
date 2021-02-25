package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lab_test_groups")
public class LabTestGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "labTestGroup")
    private Set<Service> services;

    @OneToMany(mappedBy = "labTestGroup")
    private Set<LabTest> labTests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    @JsonIgnore
    public Set<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        if(service != null){
            if(services == null){
                this.services = new HashSet<>();
            }
            service.setLabTestGroup(this);
            this.services.add(service);
        }
    }

    @JsonBackReference
    @JsonIgnore
    public Set<LabTest> getLabTests() {
        return labTests;
    }

    public void setLabTests(Set<LabTest> labTests) {
        this.labTests = labTests;
    }
}
