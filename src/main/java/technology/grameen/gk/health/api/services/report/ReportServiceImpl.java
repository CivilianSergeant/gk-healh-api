package technology.grameen.gk.health.api.services.report;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;
import technology.grameen.gk.health.api.repositories.ServiceRecordRepository;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    ServiceRecordRepository serviceRecordRepository;
    PatientManageService patientManageService;


    ReportServiceImpl(ServiceRecordRepository serviceRecordRepository,
                      PatientManageService patientManageService){
        this.serviceRecordRepository = serviceRecordRepository;
        this.patientManageService = patientManageService;
    }

    @Override
    public List<ServiceRecord> getPatientInvoiceSummery() {
        return this.serviceRecordRepository.getServiceRecords();
    }

    @Override
    public List<ServiceRecord> getPatientInvoiceSummery(LocalDate fromDate, LocalDate toDate) {
        return serviceRecordRepository.getServiceRecords(fromDate,toDate);
    }

    @Override
    public PatientManageService getPatientService() {
        return patientManageService;
    }
}
