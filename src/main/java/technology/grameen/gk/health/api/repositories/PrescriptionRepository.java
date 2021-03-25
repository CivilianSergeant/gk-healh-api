package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Prescription;
import technology.grameen.gk.health.api.projection.PrescriptionDetail;
import technology.grameen.gk.health.api.projection.PrescriptionListItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {



    @Query(value = "SELECT pr.id as prescriptionId, pr.p_number as pNumber, pr.created_at as createdAt, p.id,p.full_name as fullName " +
            " from prescriptions pr" +
            " INNER JOIN patients p ON p.id = pr.prescription_patient_id" +
            " ORDER BY pr.created_at DESC",nativeQuery = true)
    List<PrescriptionListItem> findAllPrescriptions();

    @Query(value = "SELECT p from Prescription p WHERE p.id=:id")
    Optional<PrescriptionDetail> findByPatientId(@Param("id") Long id);


}
