package technology.grameen.gk.health.api.services.labtest;

import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.projection.LabTestDetailItem;
import technology.grameen.gk.health.api.projection.LabTestListItem;

import java.util.List;
import java.util.Optional;

public interface LabTestService {

    LabTest saveLabTest(LabTest labTest);

    List<LabTestListItem> getLabTestReports();

    Optional<LabTestDetailItem> getLabTestReportById(Long id);

    Optional<LabTestDetailItem> getLabTestReportByPatientInvoiceService(Patient patient,
                                                                 PatientInvoice patientInvoice,
                                                                 Service service);
}
