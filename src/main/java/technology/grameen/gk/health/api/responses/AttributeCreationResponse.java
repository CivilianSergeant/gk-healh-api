package technology.grameen.gk.health.api.responses;

import technology.grameen.gk.health.api.entity.Service;

public class AttributeCreationResponse implements IResponse {

    private Integer status;

    private Service service;

    public AttributeCreationResponse(Integer status, Service service) {
        this.status = status;
        this.service = service;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
