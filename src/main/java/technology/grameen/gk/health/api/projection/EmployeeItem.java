package technology.grameen.gk.health.api.projection;

import technology.grameen.gk.health.api.entity.HealthCenter;

import java.time.LocalDateTime;

public interface EmployeeItem {
    Long getId();
    Long getApiEmployeeId();
    String getFullName();
    String getDesignation();
    String getContactNumber();
    String getEmail();
    interface HealthCenter{
        Long getId();
        String getName();
        String getCenterCode();
        Integer getOfficeTypeId();
        Integer getOfficeLevel();
    }
    Boolean getIsActive();
    HealthCenter getCenter();
    String getEmployeeCode();
    LocalDateTime getCreatedAt();
    LocalDateTime getLastUpdatedAt();
}
