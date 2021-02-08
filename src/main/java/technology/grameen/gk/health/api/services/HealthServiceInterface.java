package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.Service;

import java.util.List;

public interface HealthServiceInterface {

    public Service addService(Service service);

    public List<Service> getAll();
}
