package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.PatientInvoiceAutoComplete;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientInvoiceRepository extends JpaRepository<PatientInvoice,Long> {

    @Query(value = "SELECT Max(pi.id) FROM PatientInvoice pi")
    Integer getMaxInvoiceId();


    @Query(value = "SELECT pi FROM PatientInvoice pi JOIN FETCH pi.patient p " +
            " LEFT JOIN FETCH pi.patientServiceDetails psd " +
            " LEFT JOIN FETCH psd.service s JOIN FETCH s.serviceCategory sc" +
            " JOIN FETCH p.center pc " +
            " LEFT JOIN FETCH p.detail d" +
            " LEFT JOIN FETCH p.registration r " +
            " LEFT JOIN FETCH r.members m " +
            " LEFT JOIN FETCH p.prescriptions ps" +
            " LEFT JOIN FETCH s.labTestAttributes lta" +
            " LEFT JOIN FETCH lta.labTestUnit ltu" +
            " JOIN FETCH p.createdBy createdBy where pi.id = :number")
    Optional<PatientInvoiceDetail> findByInvoiceId(@Param("number") Long number);

    List<PatientInvoiceAutoComplete> findByInvoiceNumberContaining(String number);

    @Query(value = "SELECT SUM (PAID_AMOUNT) FROM patient_invoices " +
            "WHERE CREATED_AT BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') " +
            "AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')",nativeQuery = true)
    Optional<BigDecimal> getTotalAmount(@Param("fromDate") String fromDate, @Param("toDate") String  toDate);

    @Query(value = "SELECT SUM (PAID_AMOUNT) FROM patient_invoices " +
            "WHERE CREATED_AT <  " +
            " TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS')",nativeQuery = true)
    Optional<BigDecimal> getTotalAmountUptoLastDay(@Param("toDate") String  toDate);

    @Query(value ="SELECT SUM (PAID_AMOUNT) FROM patient_invoices " +
            "WHERE CREATED_AT BETWEEN TO_DATE(:fromDate,'YYYY-MM-DD HH24:MI:SS') " +
            "AND TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS') " +
            "AND HEALTH_CENTER_ID IN :centerIds",nativeQuery = true)
    Optional<BigDecimal> getTotalAmountByCenterIds(@Param("centerIds") List<Long> centerIds,
                                         @Param("fromDate") String fromDate,
                                         @Param("toDate") String toDate);

    @Query(value ="SELECT SUM (PAID_AMOUNT) FROM patient_invoices " +
            "WHERE CREATED_AT < " +
            " TO_DATE(:toDate,'YYYY-MM-DD HH24:MI:SS') " +
            "AND HEALTH_CENTER_ID IN :centerIds",nativeQuery = true)
    Optional<BigDecimal> getTotalAmountByCenterIdsUpToLastDay(@Param("centerIds") List<Long> centerIds,

                                                   @Param("toDate") String toDate);
}
