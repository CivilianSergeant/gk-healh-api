package technology.grameen.gk.health.api.services;

import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.entity.ServiceCategory;
import technology.grameen.gk.health.api.repositories.ServiceRepository;

import java.util.List;

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
        if(serviceCategory != null) {
            serviceCategory.addServices(service);
            serviceRepository.save(service);
        }
        return service;
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }
}
