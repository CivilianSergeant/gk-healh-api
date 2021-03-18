package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.projection.ServiceListItem;
import technology.grameen.gk.health.api.entity.Service;

import java.util.List;
import java.util.Optional;

public interface HealthServiceInterface {

    public Service addService(Service service);

    public Optional<Service> findServiceById(Long id);

    public Service addServiceAttributes(Service service) throws Exception;

    public List<ServiceListItem> getAll();

    public List<ServiceListItem> getLabServices();

    void deleteAttributeById(Long id);
}
