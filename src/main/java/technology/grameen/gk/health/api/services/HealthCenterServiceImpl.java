package technology.grameen.gk.health.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.repositories.HealthCenterRepository;

import java.util.List;
import java.util.Set;

@Service
public class HealthCenterServiceImpl implements HealthCenterService {


    HealthCenterRepository healthCenterRepository;

    public HealthCenterServiceImpl(HealthCenterRepository repo){
        this.healthCenterRepository = repo;
    }

    @Override
    @Transactional
    public HealthCenter addCenter(HealthCenter center) {
        healthCenterRepository.save(center);
        return center;
    }

    @Override
    public List<HealthCenter> getCenters() {
        return healthCenterRepository.findAll();
    }
}
