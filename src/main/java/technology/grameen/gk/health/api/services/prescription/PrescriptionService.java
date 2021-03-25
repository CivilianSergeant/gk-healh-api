package technology.grameen.gk.health.api.services.prescription;

import technology.grameen.gk.health.api.entity.Prescription;
import technology.grameen.gk.health.api.projection.PrescriptionDetail;
import technology.grameen.gk.health.api.projection.PrescriptionListItem;

import java.util.List;
import java.util.Optional;

public interface PrescriptionService {

    Prescription savePrescription(Prescription prescription);

    List<PrescriptionListItem> getPrescriptions();

    Optional<PrescriptionDetail> getPrescriptionById(Long id);
}
