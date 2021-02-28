package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technology.grameen.gk.health.api.entity.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service,Long> {

    @Query("SELECT s,sc,ltg from Service s JOIN FETCH s.serviceCategory sc LEFT JOIN FETCH s.labTestGroup ltg ORDER BY " +
            "s.serviceId DESC")
    List<Service> findAll();

    Optional<Service> findByCode(String code);


}
