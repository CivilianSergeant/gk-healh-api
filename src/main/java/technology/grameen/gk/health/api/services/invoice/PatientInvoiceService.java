package technology.grameen.gk.health.api.services.invoice;

import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientInvoiceAutoComplete;

import java.util.List;
import java.util.Optional;

public interface PatientInvoiceService {

    Boolean createInvoice(Patient patient) throws Exception;

    Optional<PatientInvoiceDetail> getInvoiceById(Long id);

    List<PatientInvoiceAutoComplete> getInvoiceByNumber(String number);
}
