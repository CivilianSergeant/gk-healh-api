package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.OperationCategory;

@Repository
public interface OperationCategoryRepository extends JpaRepository<OperationCategory,Integer> {

    Page<OperationCategory> findAllByName(String name, Pageable pageable);
}
