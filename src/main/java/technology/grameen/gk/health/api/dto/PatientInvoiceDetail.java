package technology.grameen.gk.health.api.dto;

import technology.grameen.gk.health.api.entity.Patient;

public interface PatientInvoiceDetail {

    String getInvoiceNumber();

    Patient getPatient();
}
