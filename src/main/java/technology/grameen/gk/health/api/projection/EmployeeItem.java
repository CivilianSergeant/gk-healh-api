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
    HealthCenter getCenter();
    String getEmployeeCode();
    Boolean getActive();
    LocalDateTime getCreatedAt();
    LocalDateTime getLastUpdatedAt();
}
