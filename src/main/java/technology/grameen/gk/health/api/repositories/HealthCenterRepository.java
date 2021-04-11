package technology.grameen.gk.health.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.HealthCenter;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface HealthCenterRepository extends JpaRepository<HealthCenter,Long> {

    @Query("SELECT c FROM HealthCenter c")
    List<HealthCenter> findAll();

    Optional<HealthCenter> findByApiOfficeId(Long apiCenterId);

    List<HealthCenter> findByNameContainingIgnoreCase(String keyword);
}
