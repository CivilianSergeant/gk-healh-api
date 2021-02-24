package technology.grameen.gk.health.api.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "lab_tests")
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "patient_invoice_id", referencedColumnName = "id")
    private PatientInvoice patientInvoice;

    @ManyToOne
    @JoinColumn(name = "specimen_id", referencedColumnName = "id")
    private Specimen specimen;

    @ManyToOne
    @JoinColumn(name = "lab_test_group_id", referencedColumnName = "id")
    private LabTestGroup labTestGroup;

    @OneToMany(mappedBy = "labTest")
    private Set<LabTestDetail> details;

    private LocalDateTime testDate;
    private LocalDateTime receivedDate;
    private LocalDateTime printDate;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private Employee createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

}
