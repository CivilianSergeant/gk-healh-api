package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {

    @Query("SELECT new Service(s.serviceId,sc,ltg,s.name,s.code,s.currentCost,s.currentGbCost,s.description," +
            "s.isActive,s.isLabTest,s.createdAt,s.lastUpdatedAt) " +
            "from Service s JOIN s.serviceCategory sc LEFT JOIN s.labTestGroup ltg ORDER BY " +
            "s.serviceId DESC")
    List<Service> findAll();

    Optional<Service> findByCode(String code);


}
