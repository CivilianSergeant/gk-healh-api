package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.LabTest;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest,Long> {
}
