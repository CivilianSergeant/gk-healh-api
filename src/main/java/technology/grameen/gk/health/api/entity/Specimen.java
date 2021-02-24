package technology.grameen.gk.health.api.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "specimens")
public class Specimen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String alias;

    @OneToMany(mappedBy = "specimen")
    private Set<LabTest> labTests;
}
