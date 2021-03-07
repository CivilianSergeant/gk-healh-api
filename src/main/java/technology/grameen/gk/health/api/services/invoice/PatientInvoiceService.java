package technology.grameen.gk.health.api.services.invoice;

import technology.grameen.gk.health.api.dto.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.dto.PatientInvoiceAutoComplete;

import java.util.List;
import java.util.Optional;

public interface PatientInvoiceService {

    void createInvoice(Patient patient) throws Exception;

    Optional<PatientInvoiceDetail> getInvoiceById(Long id);

    List<PatientInvoiceAutoComplete> getInvoiceByNumber(String number);
}
