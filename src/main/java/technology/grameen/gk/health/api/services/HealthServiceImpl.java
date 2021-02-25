package technology.grameen.gk.health.api.services;

import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.LabTestGroup;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.repositories.ServiceRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class HealthServiceImpl implements HealthServiceInterface {

    ServiceRepository serviceRepository;

    public HealthServiceImpl(ServiceRepository serviceRepository){
        this.serviceRepository=serviceRepository;
    }

    @Override
    @Transactional
    public Service addService(Service service) {
        ServiceCategory serviceCategory = service.getServiceCategory();
        LabTestGroup labTestGroup = service.getLabTestGroup();
        if(serviceCategory != null) {
            serviceCategory.addServices(service);

        }
        if(labTestGroup != null){
            labTestGroup.addService(service);
        }
        serviceRepository.save(service);
        serviceRepository.flush();
        return service;
    }

    public Optional<Service> findServiceById(Long id){
        Optional<Service> serviceRes = serviceRepository.findById(id);
        Service service = null;
        if(serviceRes.isPresent()){
            service = serviceRes.get();
            service.getLabTestGroup();
        }
        return Optional.ofNullable(service);
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }
}
