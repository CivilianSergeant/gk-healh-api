package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Village;
import technology.grameen.gk.health.api.projection.VillageListItem;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
    List<Village> findByUnionId(Long unionId);
    List<Village> findByCenterId(Long centerId);

    @Query(value = "select lg_village_Id as lgVillageId,village_code as villageCode, \n" +
            "village_name as villageName,\n" +
            "lu.UNION_NAME AS unionName,\n" +
            "lt.THANA_NAME AS thanaName,\n" +
            "ld.DISTRICT_NAME AS districtName,\n" +
            "ld2.DIVISION_NAME AS divisionName,\n" +
            "hc.NAME AS center\n" +
            "from lg_villages lv \n" +
            "INNER JOIN LG_UNIONS lu \n" +
            "ON lv.UNION_ID = lu.UNION_ID \n" +
            "INNER JOIN LG_THANAS lt \n" +
            "ON lv.THANA_ID = lt.THANA_ID \n" +
            "inner JOIN LG_DISTRICTS ld \n" +
            "ON lv.DISTRICT_ID = ld.DISTRICT_ID \n" +
            "INNER JOIN LG_DIVISIONS ld2 \n" +
            "ON lv.DIVISION_ID = ld2.DIVISION_ID \n" +
            "LEFT JOIN HEALTH_CENTERS hc \n" +
            "ON lv.CENTER_ID = hc.ID ", countQuery = "select count(*) from lg_villages", nativeQuery = true)
    Page<VillageListItem> findAllVillage(Pageable pageable);
}
