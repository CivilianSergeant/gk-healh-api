package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.EventCategory;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory,Integer> {
    Page<EventCategory> findAllByName(String name, Pageable pageable);
}
