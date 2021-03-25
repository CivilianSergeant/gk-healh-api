package technology.grameen.gk.health.api.services.report;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;
import technology.grameen.gk.health.api.repositories.ServiceRecordRepository;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    ServiceRecordRepository serviceRecordRepository;


    ReportServiceImpl(ServiceRecordRepository serviceRecordRepository){
        this.serviceRecordRepository = serviceRecordRepository;
    }

    @Override
    public List<ServiceRecord> getPatientInvoiceSummery() {
        return this.serviceRecordRepository.getServiceRecords();
    }
}
