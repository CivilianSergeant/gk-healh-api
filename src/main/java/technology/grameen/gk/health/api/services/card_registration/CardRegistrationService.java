package technology.grameen.gk.health.api.services.card_registration;

import technology.grameen.gk.health.api.entity.Patient;

public interface CardRegistrationService {

    Boolean register(Patient patient) throws Exception;
}
