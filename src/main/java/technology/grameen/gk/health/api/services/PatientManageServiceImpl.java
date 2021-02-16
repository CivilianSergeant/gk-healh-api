package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.*;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
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


        if(req.getCardRegistration() != null){
            CardRegistration cardRegistration = req.getCardRegistration();
            cardRegistration.setCardNumber(getCardNumber(center));
            cardRegistration.setStartDate(getRegistrationStartDate());
            cardRegistration.setExpiredDate(getRegistrationExpireDate());
            cardRegistration.setTotalServiceTaken(0);
            patient.addRegistration(cardRegistration);
            cardRegistrationRepository.save(cardRegistration);

            if(cardRegistration.getId()>0){
                cardRegistration.getMembers()
                        .stream()
                        .map(cardMember -> {
                            cardMember.setCardRegistration(cardRegistration);

                            return cardMember;
                        }).collect(Collectors.toSet());
                cardMemberRepository.saveAll(cardRegistration.getMembers());
            }
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

    @Override
    public Patient cardRegister(CardRegistration cardRegistration) throws Exception {

        Optional<technology.grameen.gk.health.api.entity.Service> findService = serviceRepository.findByCode("103");

        technology.grameen.gk.health.api.entity.Service service = null;

        if(findService.isPresent()){
            service = findService.get();
        }

        if(service ==null){
            throw new Exception("Service Not found");
        }

        Optional<Patient> findPatient = patientRepository.findById(cardRegistration.getPatient().getId());
        Patient patient = null;

        if(findPatient.isPresent()==false){
            throw new Exception("Patient Not found");
        }

        if(findPatient.isPresent()){
            patient = findPatient.get();
            HealthCenter center = patient.getCenter();
            cardRegistration.setCardNumber(getCardNumber(center));
            cardRegistration.setStartDate(getRegistrationStartDate());
            cardRegistration.setExpiredDate(getRegistrationExpireDate());
            cardRegistration.setTotalServiceTaken(0);
            patient.addRegistration(cardRegistration);
            cardRegistration.setActive(true);
            cardRegistrationRepository.save(cardRegistration);

            if(cardRegistration.getId()>0){

                PatientInvoice patientInvoice = new PatientInvoice();
                center.addPatientInvoices(patientInvoice);
                patient.addPatientInvoices(patientInvoice);

                patientInvoice.setCreatedBy(patient.getCreatedBy());
                patientInvoice.setInvoiceNumber(String.valueOf(Math.random()*100));
                patientInvoice.setServiceAmount(service.getCurrentCost());
                patientInvoice.setPayableAmount(service.getCurrentCost());
                patientInvoice.setDiscountAmount(BigDecimal.valueOf(0));
                patientInvoice.setPaidAmount(BigDecimal.valueOf(0));

                invoiceRepository.save(patientInvoice);

                if(patientInvoice.getId()>0){
                    PatientService patientService = new PatientService();
                    patientService.setServiceQty(1);
                    patientService.setServiceAmount(service.getCurrentCost());
                    patientService.setPayableAmount(service.getCurrentCost());
                    patientService.setDiscountAmount(BigDecimal.valueOf(0));
                    service.addPatientService(patientService);
                    patientInvoice.addPatientService(patientService);

                    patientServiceRepository.save(patientService);
                }


            }
        }
        return patient;
    }

    Patient getPatient(PatientRequest req) throws Exception {
        Patient patient = new Patient();
        Optional<HealthCenter> center = this.centerService.findById(req.getCenter().getId());
        if(center.isPresent() == false){
            throw new Exception("Center not found");
        }
        patient.setCreatedBy(req.getCreatedBy());
        patient.setPid(getPid(center.get()));
        patient.setCenter(center.get());
        patient.setFullName(req.getFullName());
        patient.setGuardianName(req.getGuardianName());
        patient.setMotherName(req.getMotherName());
        patient.setMobileNumber(req.getMobileNumber());
        patient.setMaritalStatus(req.getMaritalStatus());
        patient.setGender(req.getGender());
        patient.setDateOfBirth(req.getDateOfBirth());
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

    String getCardNumber(HealthCenter center){
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int month = (calendar.get(Calendar.MONTH));
        int maxId = ((patientRepository.getMaxCardRegId() !=null)? (patientRepository.getMaxCardRegId()+1): 1);
        return center.getCenterCode()+"-"+ year + (((month+1)<10)? "0"+(month+1) :
                (month+1)) + ((maxId<10)? "0"+maxId : maxId);
    }

    LocalDateTime getRegistrationStartDate(){

        return LocalDateTime.now();
    }

    LocalDateTime getRegistrationExpireDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,12);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(),zoneId);
    }


}
