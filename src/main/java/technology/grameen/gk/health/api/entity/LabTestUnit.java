package technology.grameen.gk.health.api.entity;

import javax.persistence.*;
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



}
