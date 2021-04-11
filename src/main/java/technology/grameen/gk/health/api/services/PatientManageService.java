package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientSearchResult;
import technology.grameen.gk.health.api.projection.PatientNumberAutoComplete;
import technology.grameen.gk.health.api.requests.PatientRequest;
import technology.grameen.gk.health.api.requests.PatientSearch;
import technology.grameen.gk.health.api.responses.PatientListItem;

import java.util.List;
import java.util.Optional;

public interface PatientManageService {

   Patient addPatient(PatientRequest patient) throws Exception;

   Page<PatientListItem> getPatients(Pageable pageable);

   Optional<PatientSearchResult> getPatientById(Long id);

   Optional<PatientSearchResult> getPatientByPId(String id);

//   Boolean cardRegister(CardRegistration cardRegistration) throws Exception;

   Integer getMaxCardRegId();

   Patient  getReference(Long id);

   List<PatientNumberAutoComplete> getPatientIds(String pid);


   Page<PatientListItem> getPatientsBySearch(Long centerId, String field, String value, Pageable pageable);
}
