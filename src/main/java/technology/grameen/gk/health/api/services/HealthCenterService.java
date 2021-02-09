package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.HealthCenter;

import java.util.List;

public interface HealthCenterService {

    HealthCenter addCenter(HealthCenter center);

    List<HealthCenter> getCenters();
}
