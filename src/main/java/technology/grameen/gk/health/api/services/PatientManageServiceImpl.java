package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.projection.PatientNumberAutoComplete;
import technology.grameen.gk.health.api.repositories.*;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientManageServiceImpl implements PatientManageService {

    private PatientRepository patientRepository;

    private PatientDetailRepository detailRepository;

    private CardRegistrationRepository cardRegistrationRepository;

    private CardMemberRepository cardMemberRepository;

    private HealthCenterService centerService;

    private PatientInvoiceRepository invoiceRepository;
    private PatientServiceRepository patientServiceRepository;

    private ServiceRepository serviceRepository;


    PatientManageServiceImpl(PatientRepository patientRepository,
                             PatientDetailRepository detailRepository,
                             CardRegistrationRepository cardRegistrationRepository,
                             CardMemberRepository cardMemberRepository,
                             HealthCenterService centerService,
                             PatientInvoiceRepository invoiceRepository,
                             PatientServiceRepository patientServiceRepository,
                             ServiceRepository serviceRepository){
        this.patientRepository = patientRepository;
        this.detailRepository = detailRepository;
        this.cardRegistrationRepository = cardRegistrationRepository;
        this.cardMemberRepository = cardMemberRepository;
        this.centerService = centerService;
        this.invoiceRepository = invoiceRepository;
        this.serviceRepository = serviceRepository;
        this.patientServiceRepository = patientServiceRepository;
    }

    @Override
    @Transactional
    public Patient addPatient(PatientRequest req) throws Exception {

//        Optional<technology.grameen.gk.health.api.entity.Service> findService = serviceRepository.findByCode("103");
//
//        technology.grameen.gk.health.api.entity.Service service = null;
//
//        if(findService.isPresent()){
//            service = findService.get();
//        }
//
//        if(service ==null){
//            throw new Exception("Card Registration Service Not found with code 103");
//        }

        Patient patient = getPatient(req);
        HealthCenter center = patient.getCenter();
        Employee employee = patient.getCreatedBy();

        center.addPatient(patient);
        employee.addPatient(patient);

        patientRepository.save(patient);

        PatientDetail detail = patient.getDetail();
        if(detail != null) {
            detail.setPatient(patient);
            detailRepository.save(detail);
        }

        return patient;
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return this.patientRepository.findById(id);
    }

    @Override
    public Optional<Patient> getPatientByPId(String pid){
        return this.patientRepository.findByPid(pid);
    }

    Patient getPatient(PatientRequest req) throws Exception {
        Patient patient = new Patient();
        Optional<HealthCenter> center = this.centerService.findById(req.getCenter().getId());
        if(center.isPresent() == false){
            throw new Exception("Center not found");
        }
        patient.setId(req.getId());
        patient.setCreatedBy(req.getCreatedBy());

        if(patient.getId()==null) {
            patient.setPid(getPid(center.get()));
        }else{
            patient.setPid(req.getPid());
        }

        patient.setCenter(center.get());
        patient.setFullName(req.getFullName());
        patient.setGuardianName(req.getGuardianName());
        patient.setMotherName(req.getMotherName());
        patient.setMobileNumber(req.getMobileNumber());
        patient.setMaritalStatus(req.getMaritalStatus());
        patient.setGender(req.getGender());
        patient.setAge(req.getAge());
        patient.setApiVillageId(req.getApiVillageId());
        patient.setVillage(req.getVillage());
        patient.setDetail(req.getDetail());
        return patient;
    }

    String getPid(HealthCenter center){
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int month = (calendar.get(Calendar.MONTH));
        int maxId = ((patientRepository.getMaxId()!=null)? (patientRepository.getMaxId()+1) : 1);
        return center.getCenterCode()+"-"+ year + (((month+1)<10)? "0"+(month+1) :
                (month+1)) + ((maxId<10)? "0"+maxId : maxId);
    }

    @Override
    public Integer getMaxCardRegId() {
        return ((patientRepository.getMaxCardRegId() !=null)? (patientRepository.getMaxCardRegId()+1): 1);
    }

    @Override
    public Patient getReference(Long id) {
         Patient patient = patientRepository.getOne(id);
         return patient;
    }

    @Override
    public List<PatientNumberAutoComplete> getPatientIds(String pid) {
        return patientRepository.findByPidStartingWithIgnoreCase(pid);
    }
}
