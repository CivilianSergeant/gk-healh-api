package technology.grameen.gk.health.api.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.HealthCenter;

import java.util.List;
import java.util.Optional;

public interface HealthCenterService {

    HealthCenter addCenter(HealthCenter center);

    HealthCenter updateCenter(HealthCenter center);

    List<HealthCenter> getCenters();
    List<HealthCenter> getRaCenters();

    Page<HealthCenter> getCenters(Pageable pageable);

    Page<HealthCenter> getCenters(String thirdLevel, String name, String code, Pageable pageable);

    Optional<HealthCenter> findById(Long id);

    Optional<HealthCenter> getCenterByApiCenterId(Long apiCenterId);

    List<HealthCenter> getCentersByKeyword(String keyword);

    List<HealthCenter> getCentersByOfficeTypeId(Integer officeTypeId);

    List<HealthCenter> getCentersByOfficeLevel(Integer officeLevel);

    List<HealthCenter> getCentersByThirdLevel(String thirdLevel);

    List<HealthCenter> getCenterById(Long id);

    List<String> getCenterIds();
    List<String> getCenterIds(String thirdLevelCode);
}
