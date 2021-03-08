package technology.grameen.gk.health.api.dto;

import technology.grameen.gk.health.api.entity.LabTestGroup;

import java.math.BigDecimal;

public interface ServiceListItem {
    Long getServiceId();
    String getName();
    String getCode();
    interface ServiceCategory{
        Long getId();
        String getName();
    }

    ServiceCategory getServiceCategory();
    LabTestGroup getLabTestGroup();
    BigDecimal getCurrentGbCost();
    BigDecimal getCurrentCost();
    Boolean getActive();
    Boolean getLabTest();
}
