package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import technology.grameen.gk.health.api.entity.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {

    @Query("SELECT s,sc from Service s JOIN FETCH s.serviceCategory sc")
    public List<Service> findAll();
}
