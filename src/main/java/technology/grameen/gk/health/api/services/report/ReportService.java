package technology.grameen.gk.health.api.services.report;

import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.exceptions.CustomException;
import technology.grameen.gk.health.api.projection.MonthWiseReceived;
import technology.grameen.gk.health.api.projection.ServiceRecord;
import technology.grameen.gk.health.api.projection.event.schedule.HCenter;
import technology.grameen.gk.health.api.repositories.EventRepository;
import technology.grameen.gk.health.api.requests.ServiceRecordSearch;
import technology.grameen.gk.health.api.responses.ServiceRecordResponse;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {

     List<ServiceRecord>  getPatientInvoiceSummery();

     List<ServiceRecordResponse> getPatientInvoiceSummery(ServiceRecordSearch serviceRecordSearch);

     PatientManageService getPatientService();

     MonthWiseReceived getMonthWiseTotalAmountReceived(Long centerId);

    List<HCenter> getEventSchedule(String raCode, String yearMonth) throws CustomException;
}
