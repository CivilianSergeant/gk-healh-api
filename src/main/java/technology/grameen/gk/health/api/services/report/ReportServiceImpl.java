package technology.grameen.gk.health.api.services.report;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.projection.MonthWiseReceived;
import technology.grameen.gk.health.api.projection.ServiceRecord;
import technology.grameen.gk.health.api.repositories.ServiceRecordRepository;
import technology.grameen.gk.health.api.requests.ServiceRecordSearch;
import technology.grameen.gk.health.api.responses.ServiceRecordResponse;
import technology.grameen.gk.health.api.services.HealthCenterService;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Long> centerIds = new ArrayList<>();
        if(serviceRecordSearch.getOfficeTypeId() == 1 || serviceRecordSearch.getOfficeTypeId() == 4){
            centers = healthCenterService.getCenters();
        }else if(serviceRecordSearch.getOfficeTypeId()==5){
            centers = healthCenterService
                    .getCentersByThirdLevel(serviceRecordSearch
                            .getCenterCode());
        }else{
            centers = healthCenterService.getCenterById(serviceRecordSearch.getCenterId());
        }
        List<ServiceRecordResponse> serviceRecordResponses = new ArrayList<>();



        centers.stream().forEach(center->{
            centerIds.add(center.getId());
        });

        List<ServiceRecord>  serviceRecords = (List<ServiceRecord>) serviceRecordRepository.getServiceRecords(centerIds,
                serviceRecordSearch.getFromDate(),serviceRecordSearch.getToDate());

        centers.stream().forEach(center->{
            List<ServiceRecord> centerWiseRecords = new ArrayList<>();
             serviceRecords.stream()
                   .forEach((ServiceRecord sr)->{
                       Long id = sr.getHealthCenterId();
                       Long centerId = center.getId();
                       if(id.equals(centerId)){
                           centerWiseRecords.add(sr);
                       }

                   });


            if(centerWiseRecords.size()>0) {
                serviceRecordResponses.add(new ServiceRecordResponse(center, centerWiseRecords));
            }
        });
        return serviceRecordResponses;
    }

    @Override
    public PatientManageService getPatientService() {
        return patientManageService;
    }

    @Override
    public MonthWiseReceived getMonthWiseTotalAmountReceived(Long centerId) {
        Optional<HealthCenter> centerOptional = healthCenterService.findById(centerId);
        final List<Long> centerIds = new ArrayList<>();
        List<HealthCenter> centers = new ArrayList<>();

        if(centerOptional.isPresent()){
            HealthCenter center = centerOptional.get();
            if(center.getOfficeTypeId() == 1 || center.getOfficeTypeId() == 4){
                List<String> strList = healthCenterService.getCenterIds();
                Optional<String> rowOp   = strList.stream().findFirst();
                String row = rowOp.get();
                Arrays.stream(row.split(",")).forEach(m->{
                    centerIds.add(Long.valueOf(m));
                });
            }
            if(center.getOfficeTypeId() == 5){
                List<String> strList = healthCenterService.getCenterIds(center.getCenterCode());
                Optional<String> rowOp   = strList.stream().findFirst();
                String row = rowOp.get();
                Arrays.stream(row.split(",")).forEach(m->{
                    centerIds.add(Long.valueOf(m));
                });

            }
            else{
                centerIds.add(centerId);
            }
        }
        return patientManageService.getInvoiceRepository().getTotalAmountMonthWiseInCenters(centerIds);
    }
}
