package technology.grameen.gk.health.api.services.operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.OperationPackage;

import java.util.List;
import java.util.Optional;

public interface OperationPackageService {

    OperationPackage addPackage(OperationPackage operationPackage);

    Page<OperationPackage> getOperationPackages(String name, Pageable pageable);

    List<OperationPackage> getOperationPackages();

    Optional<OperationPackage> getById(Integer id);
}
