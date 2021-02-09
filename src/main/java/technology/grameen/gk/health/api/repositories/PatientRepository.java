package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    public Page<Patient> findAll(Pageable page);
}
