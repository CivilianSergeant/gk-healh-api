package technology.grameen.gk.health.api.requests;

import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.Village;

public class LocationMappingRequest {

    private HealthCenter healthCenter;
    private Village village;

    public HealthCenter getHealthCenter() {
        return healthCenter;
    }

    public void setHealthCenter(HealthCenter healthCenter) {
        this.healthCenter = healthCenter;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
