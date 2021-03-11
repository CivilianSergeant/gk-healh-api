package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicine_brands")
public class MedicineBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
