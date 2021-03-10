package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "recommended_test_attributes")
public class RecommendedTestAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LabTestAttribute attribute;

    @ManyToOne
    private RecommendedTest recommendedTest;
}
