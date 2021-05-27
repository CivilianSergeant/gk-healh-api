package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "lg_villages")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lgVillageId;
    private String villageCode;
    private String villageName;
    private String unionCode;
    private String unionName;
    private String upozillaCode;
    private String upozillaName;
    private String districtCode;
    private String districtName;
    private String divisionCode;
    private String divisionName;
    private Long countryId;

    public Long getLgVillageId() {
        return lgVillageId;
    }

    public void setLgVillageId(Long lgVillageId) {
        this.lgVillageId = lgVillageId;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getUpozillaCode() {
        return upozillaCode;
    }

    public void setUpozillaCode(String upozillaCode) {
        this.upozillaCode = upozillaCode;
    }

    public String getUpozillaName() {
        return upozillaName;
    }

    public void setUpozillaName(String upozillaName) {
        this.upozillaName = upozillaName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
