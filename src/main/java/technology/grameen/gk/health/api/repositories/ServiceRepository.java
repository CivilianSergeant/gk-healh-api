package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
//   new Service(s.serviceId,sc,ltg,s.name,s.code,s.currentCost,s.currentGbCost,s.description," +
//              "s.isActive,s.isLabTest,s.createdAt,s.lastUpdatedAt)

    @EntityGraph("select-row-def")
    @Query(value = "SELECT s FROM Service s " +
            " JOIN Fetch  s.serviceCategory sc " +
            " LEFT JOIN Fetch s.labTestGroup ltg")
    List<Service> findAll();

    Optional<Service> findByCode(String code);

    @EntityGraph("select-row-def")
    @Override
    @Query("SELECT s FROM Service s JOIN FETCH s.serviceCategory sc " +
            " LEFT JOIN FETCH s.labTestGroup ltg WHERE s.serviceId = :id")
    Optional<Service> findById(@Param("id") Long id);
}
