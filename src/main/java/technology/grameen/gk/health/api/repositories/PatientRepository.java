package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.responses.PatientListItem;
import javax.persistence.NamedAttributeNode;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "SELECT new technology.grameen.gk.health.api.responses.PatientListItem (p.id, p.pid, p.fullName, " +
            "p.gender, p.maritalStatus," +
            "p.dateOfBirth, c.name,p.guardianName," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p LEFT JOIN p.center c",
            countQuery = "SELECT count(p) FROM Patient p")
    Page<Patient> findAll(Pageable pageable);

    @Query(value = "SELECT MAX(p.id) from Patient p")
    Integer getMaxId();

    @Query(value = "SELECT Max(r.id) FROM Patient p JOIN p.registration r")
    Integer getMaxCardRegId();

    @EntityGraph(value = "pid")
    Optional<Patient> findByPid(String id);

}
