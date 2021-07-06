package technology.grameen.gk.health.api.services.operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.OperationPackage;
import technology.grameen.gk.health.api.repositories.OperationPackageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OperationPackageServiceImpl implements OperationPackageService{

    private OperationPackageRepository operationPackageRepository;

    public OperationPackageServiceImpl(OperationPackageRepository operationPackageRepository) {
        this.operationPackageRepository = operationPackageRepository;
    }

    @Override
    public OperationPackage addPackage(OperationPackage operationPackage) {
        return operationPackageRepository.save(operationPackage);
    }

    @Override
    public Page<OperationPackage> getOperationPackages(String name,Pageable pageable) {
        if(name.isEmpty()){
            return operationPackageRepository.findAll(pageable);
        }
        return operationPackageRepository.findAllByName(name,pageable);
    }

    @Override
    public List<OperationPackage> getOperationPackages() {
        return operationPackageRepository.findAll();
    }

    @Override
    public Optional<OperationPackage> getById(Integer id) {
        return operationPackageRepository.findById(id);
    }
}
