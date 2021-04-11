package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientNumberAutoComplete;
import technology.grameen.gk.health.api.projection.PatientSearchResult;
import technology.grameen.gk.health.api.responses.PatientListItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.age, c.name,p.guardianName,p.mobileNumber," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c",
            countQuery = "SELECT count(p) FROM Patient p")
    Page<PatientListItem> findAllPatients(Pageable pageable);

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.age, c.name,p.guardianName,p.mobileNumber," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c" +
            " WHERE c.id=:centerId",
            countQuery = "SELECT count(p) FROM Patient p LEFT JOIN p.center c WHERE c.id=:centerId")
    Page<PatientListItem> findByCenter(@Param("centerId") Long centerId, Pageable pageable);

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.age, c.name,p.guardianName,p.mobileNumber," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c" +
            " WHERE c.id=:centerId AND upper(p.fullName) LIKE upper(concat('%',:fullName,'%'))",
            countQuery = "SELECT count(p) FROM Patient p LEFT JOIN p.center c WHERE c.id=:centerId AND" +
                    " upper(p.fullName) LIKE upper(concat('%',:fullName,'%'))")
    Page<PatientListItem> findByCenterAndfullName(@Param("centerId") Long centerId,
                                               @Param("fullName") String fullName,
                                               Pageable pageable);

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.age, c.name,p.guardianName,p.mobileNumber," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c" +
            " WHERE c.id=:centerId AND p.mobileNumber LIKE %:mobileNumber%",
            countQuery = "SELECT count(p) FROM Patient p LEFT JOIN p.center c WHERE c.id=:centerId " +
                    "AND p.mobileNumber LIKE %:mobileNumber%")
    Page<PatientListItem> findByCenterAndMobileNo(@Param("centerId") Long centerId,
                                             @Param("mobileNumber") String mobileNumber,
                                             Pageable pageable);

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.age, c.name,p.guardianName,p.mobileNumber," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c" +
            " WHERE c.id=:centerId AND p.pid LIKE %:pid%",
            countQuery = "SELECT count(p) FROM Patient p LEFT JOIN p.center c WHERE c.id=:centerId " +
                    "AND p.pid LIKE %:pid%")
    Page<PatientListItem> findByCenterAndPid(@Param("centerId") Long centerId,
                                          @Param("pid") String pid,
                                          Pageable pageable);

    @Query(value = "SELECT MAX(p.id) from Patient p")
    Integer getMaxId();

    @Query(value = "SELECT Max(r.id) FROM Patient p JOIN p.registration r")
    Integer getMaxCardRegId();

    @Query(value = "SELECT p FROM Patient p LEFT JOIN FETCH p.registration r LEFT JOIN FETCH p.patientInvoices pi WHERE p.pid = :number")
    Optional<PatientSearchResult> findByPid(@Param("number") String id);

    @Query(value = "SELECT p FROM Patient p LEFT JOIN FETCH p.registration r " +
            "LEFT JOIN FETCH p.patientInvoices pi " +
            "LEFT JOIN FETCH pi.center c WHERE p.id = :number")
    Optional<PatientSearchResult> findPatientById(@Param("number") Long id);

    List<PatientNumberAutoComplete> findByPidContainingIgnoreCase(String number);

}
