package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.entity.PatientDetail;
import technology.grameen.gk.health.api.repositories.EmployeeRepository;
import technology.grameen.gk.health.api.repositories.HealthCenterRepository;
import technology.grameen.gk.health.api.repositories.PatientDetailRepository;
import technology.grameen.gk.health.api.repositories.PatientRepository;
import technology.grameen.gk.health.api.requests.PatientRequest;

import java.util.ArrayList;

@Service
public class PatientManageServiceImpl implements PatientManageService {

    private PatientRepository patientRepository;

    private PatientDetailRepository detailRepository;


    PatientManageServiceImpl(PatientRepository patientRepository,
                             PatientDetailRepository detailRepository){
        this.patientRepository = patientRepository;
        this.detailRepository = detailRepository;
    }

    @Override
    @Transactional
    public Patient addPatient(PatientRequest req) {
        Patient patient = new Patient();
        patient.setCenter(req.getCenter());
        patient.setCreatedBy(req.getCreatedBy());
        patient.setFullName(req.getFullName());
        patient.setGender(req.getGender());
        patient.setDetail(req.getDetail());

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
}
