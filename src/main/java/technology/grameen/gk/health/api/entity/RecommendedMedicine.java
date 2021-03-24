package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "recommended_medicines")
public class RecommendedMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Prescription prescription;

    @ManyToOne
    private Medicine medicine;

    private Integer duration;

    private String durationUnit;

    private Integer rule;
}
