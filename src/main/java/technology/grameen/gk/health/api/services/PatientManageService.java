package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.util.List;
import java.util.Optional;

public interface PatientManageService {

   Patient addPatient(PatientRequest patient) throws Exception;

   Page<Patient> getPatients(Pageable pageable);

   Optional<Patient> getPatientById(Long id);
}
