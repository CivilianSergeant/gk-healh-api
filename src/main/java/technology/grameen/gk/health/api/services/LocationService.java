package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.projection.VillageListItem;
import technology.grameen.gk.health.api.requests.LocationMappingRequest;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    public Village addLocation(Village village);
    List<Division> getDivisionList();
    Page<VillageListItem> getVillages(Pageable pageable);
    List<District> getDistrictList(Long divisionId);
    List<Thana> getThanaList(Long districtId);
    List<Union> getUnionList(Long thanaId);
    List<Village> getVillageList(Long unionId);
    Boolean villageMapping(LocationMappingRequest locationMappingRequest);

    Optional<Village> findById(Long id);

    List<Village> getCenterVillageList(Long centerId);

}
