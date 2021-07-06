package technology.grameen.gk.health.api.services.operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.OperationCategory;
import technology.grameen.gk.health.api.repositories.OperationCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OperationCategoryServiceImpl implements OperationCategoryService{

    private OperationCategoryRepository operationCategoryRepository;

    public OperationCategoryServiceImpl(OperationCategoryRepository operationCategoryRepository) {
        this.operationCategoryRepository = operationCategoryRepository;
    }

    @Override
    public OperationCategory addCategory(OperationCategory operationCategory) {
        return operationCategoryRepository.save(operationCategory);
    }

    @Override
    public Page<OperationCategory> getOperationCategories(String name,Pageable pageable) {
        if(name.isEmpty()){
            return this.operationCategoryRepository.findAll(pageable);
        }
        return this.operationCategoryRepository.findAllByName(name,pageable);
    }

    @Override
    public List<OperationCategory> getOperationCategories() {
        return operationCategoryRepository.findAll();
    }

    @Override
    public Optional<OperationCategory> getById(Integer id) {
        return operationCategoryRepository.findById(id);
    }
}
