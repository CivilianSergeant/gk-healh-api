package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Patient;

import javax.persistence.NamedAttributeNode;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {


    @Query(value = "SELECT new Patient(p.id, p.pid, p.fullName, p.gender, p.maritalStatus," +
            "p.dateOfBirth, p.center,p.guardianName," +
            "p.createdAt, p.lastUpdatedAt) FROM Patient p",
            countQuery = "SELECT count(p) FROM Patient p")
    Page<Patient> findAll(Pageable pageable);
}
