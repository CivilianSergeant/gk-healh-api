package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "patient_details")
public class PatientDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Patient patient;

    private String bloodGroup;
    private String nationality;
    private String nationalId;
    private String occupation;
}
