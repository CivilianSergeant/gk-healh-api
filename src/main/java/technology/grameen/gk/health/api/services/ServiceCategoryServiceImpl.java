package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Medicine;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.repositories.ServiceCategoryRepository;

import java.util.List;
import java.util.Optional;

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
    public Page<ServiceCategory> getCategories(Pageable pageable) {
        return serviceCategoryRepository.findAll(pageable);
    }

    @Override
    public Page<ServiceCategory> getCategories(String name, Pageable pageable) {
        if(name.isEmpty()){
            return serviceCategoryRepository.findAll(pageable);
        }
        return serviceCategoryRepository.findAllByNameContainingIgnoreCase(name,pageable);
    }

    @Override
    public Optional<ServiceCategory> findById(Long id) {
        return serviceCategoryRepository.findById(id);
    }
}
