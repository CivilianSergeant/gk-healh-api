package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "lg_divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private Long countryId;
    private String divisionCode;
    private String divisionName;
    private String divisionNameOther;
    private Boolean isRemoved;

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
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

    public String getDivisionNameOther() {
        return divisionNameOther;
    }

    public void setDivisionNameOther(String divisionNameOther) {
        this.divisionNameOther = divisionNameOther;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
