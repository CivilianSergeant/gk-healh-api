package technology.grameen.gk.health.api.services;

import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.requests.PatientRequest;

public interface PatientManageService {

   Patient addPatient(PatientRequest patient);
}
