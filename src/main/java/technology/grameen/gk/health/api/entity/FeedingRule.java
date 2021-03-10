package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "feeding_rules")
public class FeedingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rule;

    private String feedingTime;

}
