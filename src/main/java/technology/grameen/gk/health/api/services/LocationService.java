package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.*;

import java.util.List;

public interface LocationService {

    public Village addLocation(Village village);
    List<Division> getDivisionList();
    List<District> getDistrictList(Long divisionId);
    List<Thana> getThanaList(Long districtId);
    List<Union> getUnionList(Long thanaId);
    List<Village> getVillageList(Long unionId);

}
