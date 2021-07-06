package technology.grameen.gk.health.api.services.operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.OperationCategory;

import java.util.List;
import java.util.Optional;

public interface OperationCategoryService {

    OperationCategory addCategory(OperationCategory operationCategory);

    Page<OperationCategory> getOperationCategories(String name, Pageable pageable);

    List<OperationCategory> getOperationCategories();

    Optional<OperationCategory> getById(Integer id);
}
