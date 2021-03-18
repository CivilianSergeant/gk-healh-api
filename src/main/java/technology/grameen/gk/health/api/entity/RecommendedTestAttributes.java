package technology.grameen.gk.health.api.entity;

import javax.persistence.*;


public class RecommendedTestAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LabTestAttribute labTestAttribute;

    @ManyToOne
    private RecommendedTest recommendedTest;
}
