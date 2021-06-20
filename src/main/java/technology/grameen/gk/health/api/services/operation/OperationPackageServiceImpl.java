package technology.grameen.gk.health.api.services.operation;

import technology.grameen.gk.health.api.repositories.OperationPackageRepository;

public class OperationPackageServiceImpl implements OperationPackageService{

    private OperationPackageRepository operationPackageRepository;

    public OperationPackageServiceImpl(OperationPackageRepository operationPackageRepository) {
        this.operationPackageRepository = operationPackageRepository;
    }
}
