package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ServiceRecordRepository extends JpaRepository<PatientInvoice, Long> {

    @Query(value = "SELECT pi.CREATED_AT AS \"DATE\", pi.INVOICE_NUMBER as invoiceNumber , (p.FULL_NAME || ' (' || p.PID || ')') AS name , p.VILLAGE AS address,\n" +
            "pi.PAYABLE_AMOUNT AS receivableAmount ,pi.PAID_AMOUNT AS paid\n" +
            " from patient_invoices pi\n" +
            "INNER JOIN PATIENTS p ON p.ID = pi.PATIENT_ID\n" +
            "ORDER BY pi.CREATED_AT desc",nativeQuery = true)
    List<ServiceRecord> getServiceRecords();

    @Query(value = "SELECT pi.CREATED_AT AS \"DATE\",pi.PATIENT_ID as patientId, pi.HEALTH_CENTER_ID as healthCenterId, pi.id as invoiceId,  pi.INVOICE_NUMBER as invoiceNumber , (p.FULL_NAME || ' (' || p.PID || ')') AS name , p.VILLAGE AS address, " +
            "pi.PAYABLE_AMOUNT AS receivableAmount ,pi.PAID_AMOUNT AS paid " +
            " from patient_invoices pi " +
            "INNER JOIN PATIENTS p ON p.ID = pi.PATIENT_ID " +
            "WHERE pi.HEALTH_CENTER_ID IN :centerIds " +
            "AND pi.CREATED_AT BETWEEN :fromDate AND :toDate " +
            "ORDER BY pi.CREATED_AT desc",nativeQuery = true)
    List<ServiceRecord> getServiceRecords(@Param("centerIds") List<Long> centerIds,
                                          @Param("fromDate") LocalDateTime fromDate,
                                          @Param("toDate") LocalDateTime toDate);


}
