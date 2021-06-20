package technology.grameen.gk.health.api.services.operation;

import technology.grameen.gk.health.api.repositories.OperationCategoryRepository;

public class OperationCategoryServiceImpl implements OperationCategoryService{

    private OperationCategoryRepository operationCategoryRepository;

    public OperationCategoryServiceImpl(OperationCategoryRepository operationCategoryRepository) {
        this.operationCategoryRepository = operationCategoryRepository;
    }
}
