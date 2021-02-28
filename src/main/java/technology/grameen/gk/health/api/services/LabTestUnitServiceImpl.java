package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.LabTestUnit;
import technology.grameen.gk.health.api.repositories.LabTestUnitRepository;

import java.util.List;

@Service
public class LabTestUnitServiceImpl implements LabTestUnitService {


    LabTestUnitRepository labTestUnitRepository;

    LabTestUnitServiceImpl(LabTestUnitRepository labTestUnitRepository){
        this.labTestUnitRepository = labTestUnitRepository;
    }

    @Override
    public List<LabTestUnit> getAllUnits() {
        return labTestUnitRepository.findAll();
    }

    @Override
    public void save(LabTestUnit labTestUnit){
        labTestUnitRepository.save(labTestUnit);
    }
}
