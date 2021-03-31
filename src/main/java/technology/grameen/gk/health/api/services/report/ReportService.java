package technology.grameen.gk.health.api.services.report;

import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {

     List<ServiceRecord>  getPatientInvoiceSummery();

     List<ServiceRecord> getPatientInvoiceSummery(LocalDate fromDate, LocalDate toDate);
}
