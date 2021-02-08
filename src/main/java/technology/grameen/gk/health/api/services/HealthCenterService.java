package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.HealthCenter;

import java.util.List;
import java.util.Set;

public interface HealthCenterService {

    public HealthCenter addCenter(HealthCenter center);

    public List<HealthCenter> getCenters();
}
