package technology.grameen.gk.health.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.HealthCenter;

import javax.persistence.EntityManager;

@Repository
public interface HealthCenterRepository extends JpaRepository<HealthCenter,Long> {


}
