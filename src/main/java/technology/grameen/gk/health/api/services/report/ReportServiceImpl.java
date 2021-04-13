package technology.grameen.gk.health.api.services.report;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.ServiceRecord;
import technology.grameen.gk.health.api.repositories.ServiceRecordRepository;
import technology.grameen.gk.health.api.requests.ServiceRecordSearch;
import technology.grameen.gk.health.api.responses.ServiceRecordResponse;
import technology.grameen.gk.health.api.services.HealthCenterService;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    ServiceRecordRepository serviceRecordRepository;
    PatientManageService patientManageService;
    HealthCenterService healthCenterService;


    ReportServiceImpl(ServiceRecordRepository serviceRecordRepository,
                      PatientManageService patientManageService,
                      HealthCenterService healthCenterService){
        this.serviceRecordRepository = serviceRecordRepository;
        this.patientManageService = patientManageService;
        this.healthCenterService = healthCenterService;
    }

    @Override
    public List<ServiceRecord> getPatientInvoiceSummery() {
        return this.serviceRecordRepository.getServiceRecords();
    }

    @Override
    public List<ServiceRecordResponse> getPatientInvoiceSummery(ServiceRecordSearch serviceRecordSearch) {

        List<HealthCenter> centers = new ArrayList<>();
        if(serviceRecordSearch.getOfficeTypeId() == 1 || serviceRecordSearch.getOfficeTypeId() == 4){
            centers = healthCenterService.getCenters();
        }else if(serviceRecordSearch.getOfficeTypeId()==5){
            centers = healthCenterService
                    .getCentersByOfficeTypeId(serviceRecordSearch
                            .getOfficeTypeId());
        }else{
            centers = healthCenterService.getCenterById(serviceRecordSearch.getCenterId());
        }
        List<ServiceRecordResponse> serviceRecordResponses = new ArrayList<>();
        centers.stream().forEach(center->{
            List<ServiceRecord>  serviceRecords = serviceRecordRepository.getServiceRecords(center.getId(),
                                                    serviceRecordSearch.getFromDate(),
                                                    serviceRecordSearch.getToDate());
            if(serviceRecords.size()>0) {
                serviceRecordResponses.add(new ServiceRecordResponse(center, serviceRecords));
            }
        });

        return serviceRecordResponses;
    }

    @Override
    public PatientManageService getPatientService() {
        return patientManageService;
    }
}
