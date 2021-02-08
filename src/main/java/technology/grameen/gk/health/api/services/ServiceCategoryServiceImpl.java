package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.repositories.ServiceCategoryRepository;

import java.util.List;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService {

    ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategoryServiceImpl(ServiceCategoryRepository repo){
        this.serviceCategoryRepository = repo;
    }

    @Override
    @Transactional
    public ServiceCategory addCategory(ServiceCategory category) {
        serviceCategoryRepository.save(category);
        return category;
    }

    @Override
    public List<ServiceCategory> getCategories() {
        return serviceCategoryRepository.findAll();
    }
}
