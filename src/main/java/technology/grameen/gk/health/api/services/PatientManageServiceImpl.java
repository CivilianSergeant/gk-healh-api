package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.*;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.util.ArrayList;

@Service
public class PatientManageServiceImpl implements PatientManageService {

    private PatientRepository patientRepository;

    private PatientDetailRepository detailRepository;

    private CardRegistrationRepository cardRegistrationRepository;


    PatientManageServiceImpl(PatientRepository patientRepository,
                             PatientDetailRepository detailRepository,
                             CardRegistrationRepository cardRegistrationRepository){
        this.patientRepository = patientRepository;
        this.detailRepository = detailRepository;
        this.cardRegistrationRepository = cardRegistrationRepository;
    }

    @Override
    @Transactional
    public Patient addPatient(PatientRequest req) {

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
            patient.addRegistration(cardRegistration);
            cardRegistrationRepository.save(cardRegistration);
        }
        return patient;
    }

    Patient getPatient(PatientRequest req){
        Patient patient = new Patient();
        patient.setCenter(req.getCenter());
        patient.setCreatedBy(req.getCreatedBy());
        patient.setFullName(req.getFullName());
        patient.setGender(req.getGender());
        patient.setDetail(req.getDetail());
        return patient;
    }
}
