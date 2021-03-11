package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private MedicineBrand medicineBrand;

    @ManyToOne
    private MedicineGroup medicineGroup;


}
