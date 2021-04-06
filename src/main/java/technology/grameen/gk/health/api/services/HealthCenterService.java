package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.HealthCenter;

import java.util.List;
import java.util.Optional;

public interface HealthCenterService {

    HealthCenter addCenter(HealthCenter center);

    HealthCenter updateCenter(HealthCenter center);

    List<HealthCenter> getCenters();

    Optional<HealthCenter> findById(Long id);

    Optional<HealthCenter> getCenterByApiCenterId(Long apiCenterId);
}
