package technology.grameen.gk.health.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.repositories.HealthCenterRepository;

import java.util.List;
import java.util.Optional;
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
    public HealthCenter updateCenter(HealthCenter req) {
        HealthCenter center = healthCenterRepository.findById(req.getId()).get();
        if(center==null){
            throw new RuntimeException("Center not found");
        }
        center.setCenterCode(req.getCenterCode());
        center.setName(req.getName());
        center.setFirstLevel(req.getFirstLevel());
        center.setSecondLevel(req.getSecondLevel());
        center.setThirdLevel(req.getThirdLevel());
        center.setFourthLevel(req.getFourthLevel());
        center.setFifthLevel(req.getFifthLevel());
        healthCenterRepository.save(center);
        return center;
    }

    @Override
    public List<HealthCenter> getCenters() {
        return healthCenterRepository.findAll();
    }

    @Override
    public Optional<HealthCenter> findById(Long id) {
        return healthCenterRepository.findById(id);
    }

    @Override
    public Optional<HealthCenter> getCenterByApiCenterId(Long apiCenterId) {
        return healthCenterRepository.findByApiOfficeId(apiCenterId);
    }
}
