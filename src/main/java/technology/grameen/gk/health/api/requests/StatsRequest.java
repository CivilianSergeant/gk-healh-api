package technology.grameen.gk.health.api.requests;

import technology.grameen.gk.health.api.entity.HealthCenter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatsRequest {

    private Long id;
    private Integer officeTypeId;
    private String centerCode;
    private String fromDate;
    private String toDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOfficeTypeId() {
        return officeTypeId;
    }

    public void setOfficeTypeId(Integer officeTypeId) {
        this.officeTypeId = officeTypeId;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}
