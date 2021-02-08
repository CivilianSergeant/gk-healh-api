package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import technology.grameen.gk.health.api.entity.Service;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
