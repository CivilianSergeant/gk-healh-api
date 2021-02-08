package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.ServiceCategory;

import java.util.List;

public interface ServiceCategoryService {

    public ServiceCategory addCategory(ServiceCategory category);

    public List<ServiceCategory> getCategories();
}
