package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.CardMemberRepository;
import technology.grameen.gk.health.api.repositories.CardRegistrationRepository;
import technology.grameen.gk.health.api.repositories.PatientDetailRepository;
import technology.grameen.gk.health.api.repositories.PatientRepository;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientManageServiceImpl implements PatientManageService {

    private PatientRepository patientRepository;

    private PatientDetailRepository detailRepository;

    private CardRegistrationRepository cardRegistrationRepository;

    private CardMemberRepository cardMemberRepository;


    PatientManageServiceImpl(PatientRepository patientRepository,
                             PatientDetailRepository detailRepository,
                             CardRegistrationRepository cardRegistrationRepository,
                             CardMemberRepository cardMemberRepository){
        this.patientRepository = patientRepository;
        this.detailRepository = detailRepository;
        this.cardRegistrationRepository = cardRegistrationRepository;
        this.cardMemberRepository = cardMemberRepository;
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
