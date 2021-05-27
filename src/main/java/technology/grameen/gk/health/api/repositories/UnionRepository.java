package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Union;

import java.util.List;

@Repository
public interface UnionRepository extends JpaRepository<Union, Long> {
    List<Union> findByThanaId(Long thanaId);
}
