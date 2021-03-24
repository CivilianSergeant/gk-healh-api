package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;

import java.util.List;

public interface ServiceRecordRepository extends JpaRepository<PatientInvoice, Long> {

    @Query(value = "SELECT pi.CREATED_AT AS \"DATE\", pi.INVOICE_NUMBER as invoiceNumber , (p.FULL_NAME || ' (' || p.PID || ')') AS name , p.VILLAGE AS address,\n" +
            "pi.PAYABLE_AMOUNT AS receivableAmount ,pi.PAID_AMOUNT AS paid\n" +
            " from patient_invoices pi\n" +
            "INNER JOIN PATIENTS p ON p.ID = pi.PATIENT_ID\n" +
            "ORDER BY pi.CREATED_AT desc",nativeQuery = true)
    List<ServiceRecord> getServiceRecords();
}
