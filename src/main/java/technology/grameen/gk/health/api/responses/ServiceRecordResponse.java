package technology.grameen.gk.health.api.responses;

import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.projection.ServiceRecord;

import java.util.List;

public class ServiceRecordResponse {

    HealthCenter center;
    List<ServiceRecord> serviceRecords;

    public ServiceRecordResponse(HealthCenter center, List<ServiceRecord> serviceRecords) {
        this.center = center;
        this.serviceRecords = serviceRecords;
    }

    public HealthCenter getCenter() {
        return center;
    }

    public void setCenter(HealthCenter center) {
        this.center = center;
    }

    public List<ServiceRecord> getServiceRecords() {
        return serviceRecords;
    }

    public void setServiceRecords(List<ServiceRecord> serviceRecords) {
        this.serviceRecords = serviceRecords;
    }
}
