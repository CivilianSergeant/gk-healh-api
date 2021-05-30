package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Village;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
    List<Village> findByUnionId(Long unionId);
}
