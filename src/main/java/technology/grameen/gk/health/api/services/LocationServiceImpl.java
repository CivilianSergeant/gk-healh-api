package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.*;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private DivisionRepository divisionRepository;
    private DistrictRepository districtRepository;
    private ThanaRepository thanaRepository;
    private UnionRepository unionRepository;
    private VillageRepository villageRepository;

    public LocationServiceImpl(DivisionRepository divisionRepository,
                               DistrictRepository districtRepository,
                               ThanaRepository thanaRepository,
                               UnionRepository unionRepository,
                               VillageRepository villageRepository) {
        this.divisionRepository = divisionRepository;
        this.districtRepository = districtRepository;
        this.thanaRepository = thanaRepository;
        this.unionRepository = unionRepository;
        this.villageRepository = villageRepository;
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


}
