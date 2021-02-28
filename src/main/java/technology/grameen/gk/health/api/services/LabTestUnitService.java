package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.LabTestUnit;

import java.util.List;


public interface LabTestUnitService {

    List<LabTestUnit> getAllUnits();
    void save(LabTestUnit labTestUnit);
}
