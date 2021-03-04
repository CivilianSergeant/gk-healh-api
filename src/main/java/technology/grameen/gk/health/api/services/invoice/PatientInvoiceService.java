package technology.grameen.gk.health.api.services.invoice;

import technology.grameen.gk.health.api.entity.Patient;

public interface PatientInvoiceService {

    void createInvoice(Patient patient) throws Exception;
}
