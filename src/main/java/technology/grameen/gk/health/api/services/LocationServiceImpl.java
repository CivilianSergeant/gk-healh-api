package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.*;
import technology.grameen.gk.health.api.requests.LocationMappingRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private DivisionRepository divisionRepository;
    private DistrictRepository districtRepository;
    private ThanaRepository thanaRepository;
    private UnionRepository unionRepository;
    private VillageRepository villageRepository;
    private HealthCenterService healthCenterService;


    public LocationServiceImpl(DivisionRepository divisionRepository,
                               DistrictRepository districtRepository,
                               ThanaRepository thanaRepository,
                               UnionRepository unionRepository,
                               VillageRepository villageRepository,
                               HealthCenterService healthCenterService) {
        this.divisionRepository = divisionRepository;
        this.districtRepository = districtRepository;
        this.thanaRepository = thanaRepository;
        this.unionRepository = unionRepository;
        this.villageRepository = villageRepository;
        this.healthCenterService = healthCenterService;
    }

    @Override
    @Transactional
    public Village addLocation(Village village){
        villageRepository.save(village);
        return village;
    }

    @Override
    public List<Division> getDivisionList() {
        return divisionRepository.findAll();
    }

    @Override
    public List<District> getDistrictList(Long divisionId) {
        return districtRepository.findByDivisionId(divisionId);
    }

    @Override
    public List<Thana> getThanaList(Long districtId) {
        return thanaRepository.findByDistrictId(districtId);
    }

    @Override
    public List<Union> getUnionList(Long thanaId) {
        return unionRepository.findByThanaId(thanaId);
    }

    @Override
    public List<Village> getVillageList(Long unionId) {
        return villageRepository.findByUnionId(unionId);
    }

    @Override
    public Boolean villageMapping(LocationMappingRequest locationMappingRequest) {
        Long villageId = locationMappingRequest.getVillage().getLgVillageId();
        Long centerId = locationMappingRequest.getHealthCenter().getId();
        Optional<Village> village = this.findById(villageId);
        Optional<HealthCenter> healthCenter =  healthCenterService.findById(centerId);

        if(village.isPresent() && healthCenter.isPresent()){
            Village village1 = village.get();
            HealthCenter healthCenter1 = healthCenter.get();
            healthCenter1.addVillage(village1);
            villageRepository.save(village1);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Village> findById(Long id) {
        return villageRepository.findById(id);
    }
}
