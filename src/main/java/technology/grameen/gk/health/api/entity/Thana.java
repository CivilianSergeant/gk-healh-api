package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name="lg_thanas")
public class Thana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thanaId;
    private String thanaCode;
    private Long districtId;
    private String thanaName;
    private String thanaNameOther;
    private Boolean isRemoved;

    public Long getThanaId() {
        return thanaId;
    }

    public void setThanaId(Long thanaId) {
        this.thanaId = thanaId;
    }

    public String getThanaCode() {
        return thanaCode;
    }

    public void setThanaCode(String thanaCode) {
        this.thanaCode = thanaCode;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getThanaName() {
        return thanaName;
    }

    public void setThanaName(String thanaName) {
        this.thanaName = thanaName;
    }

    public String getThanaNameOther() {
        return thanaNameOther;
    }

    public void setThanaNameOther(String thanaNameOther) {
        this.thanaNameOther = thanaNameOther;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
