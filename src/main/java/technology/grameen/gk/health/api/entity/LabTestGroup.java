package technology.grameen.gk.health.api.entity;

import javax.persistence.*;
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
}
