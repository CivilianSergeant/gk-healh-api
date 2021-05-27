package technology.grameen.gk.health.api.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "lg_districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long districtId;
    private String districtCode;
    private Long divisionId;
    private String districtName;
    private String districtNameOther;
    private Boolean isRemoved;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictNameOther() {
        return districtNameOther;
    }

    public void setDistrictNameOther(String districtNameOther) {
        this.districtNameOther = districtNameOther;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
