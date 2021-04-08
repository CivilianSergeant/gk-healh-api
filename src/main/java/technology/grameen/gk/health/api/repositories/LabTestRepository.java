package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.LabTest;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.projection.LabTestDetailItem;
import technology.grameen.gk.health.api.projection.LabTestListItem;


import java.util.List;
import java.util.Optional;


@Repository
public interface LabTestRepository extends JpaRepository<LabTest,Long> {

    @Query(value = "SELECT lt.id, lt.status, p.FULL_NAME AS fullName , p.PID as pid , pi2.INVOICE_NUMBER AS invoiceNumber, se.NAME AS serviceName," +
            " lt.CREATED_AT AS createdAt FROM  LAB_TESTS lt INNER JOIN PATIENTS p ON p.id = lt.PATIENT_ID \n" +
            "INNER JOIN PATIENT_INVOICES pi2 ON pi2.id = lt.PATIENT_INVOICE_ID " +
            "INNER JOIN SERVICE se ON se.SERVICE_ID = lt.SERVICE_ID ORDER BY lt.id DESC", nativeQuery=true)
    List<LabTestListItem> getLabTests();

    @Query("Select l from LabTest l where l.id = :id")
    Optional<LabTestDetailItem> findByLabTest(@Param("id") Long id);

    Optional<LabTestDetailItem> findByPatientAndPatientInvoiceAndService(Patient patient,
                                                                         PatientInvoice patientInvoice,
                                                                         Service service);

}
