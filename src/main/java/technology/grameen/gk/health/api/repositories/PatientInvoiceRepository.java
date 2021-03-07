package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.dto.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.dto.PatientInvoiceAutoComplete;

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
            " JOIN FETCH p.createdBy createdBy where pi.id = :number")
    Optional<PatientInvoiceDetail> findByInvoiceId(@Param("number") Long number);

    List<PatientInvoiceAutoComplete> findByInvoiceNumberStartingWith(String number);

}
