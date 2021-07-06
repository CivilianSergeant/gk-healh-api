package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.OperationPackage;

@Repository
public interface OperationPackageRepository extends JpaRepository<OperationPackage,Integer> {

    Page<OperationPackage> findAllByName(String name, Pageable pageable);
}
