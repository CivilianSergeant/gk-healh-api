package technology.grameen.gk.health.api.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recommended_tests")
public class RecommendedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Prescription prescription;

    @ManyToOne
    private Service service;

    @OneToMany(mappedBy = "recommendedTest")
    private Set<RecommendedTestAttributes> testAttributes;
}
