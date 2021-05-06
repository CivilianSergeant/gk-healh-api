package technology.grameen.gk.health.api.services.invoice;

import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.entity.PatientServiceDetail;
import technology.grameen.gk.health.api.entity.Service;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientInvoiceAutoComplete;
import technology.grameen.gk.health.api.projection.PrescriptionInvoiceAutoComplete;

import java.util.List;
import java.util.Optional;

public interface PatientInvoiceService {

    Boolean createInvoice(Patient patient) throws Exception;

    Optional<PatientInvoiceDetail> getInvoiceById(Long id);

    List<PatientInvoiceAutoComplete> getInvoiceByNumber(String number);
    List<PrescriptionInvoiceAutoComplete> getPrescriptionInvoiceByNumber();

    Optional<PatientServiceDetail> getPatientServiceDetailByInvoiceAndService(PatientInvoice patientInvoice,
                                                                              Service service);

    PatientServiceDetail updatePatientServiceDetail(PatientServiceDetail patientServiceDetail);

    Optional<PatientServiceDetail> getPrescriptionServiceDetailByPatientInvoice(PatientInvoice patientInvoice);
}
