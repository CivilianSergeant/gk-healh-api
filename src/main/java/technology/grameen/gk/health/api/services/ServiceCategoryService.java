package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.ServiceCategory;

import java.util.List;
import java.util.Optional;

public interface ServiceCategoryService {

     ServiceCategory addCategory(ServiceCategory category);

     List<ServiceCategory> getCategories();

     Optional<ServiceCategory> findById(Long id);
}
