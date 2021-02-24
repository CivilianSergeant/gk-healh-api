package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "lab_test_details")
public class LabTestDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_test_id",referencedColumnName = "id")
    private LabTest labTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    private String result;
}
