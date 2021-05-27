package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Thana;

import java.util.List;

@Repository
public interface ThanaRepository extends JpaRepository<Thana, Long> {
    List<Thana> findByDistrictId(Long districtId);
}
