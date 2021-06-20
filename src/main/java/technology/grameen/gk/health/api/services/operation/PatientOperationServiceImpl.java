package technology.grameen.gk.health.api.services.operation;

import technology.grameen.gk.health.api.repositories.PatientOperationRepository;

public class PatientOperationServiceImpl implements PatientOperationService{

    private PatientOperationRepository patientOperationRepository;

    public PatientOperationServiceImpl(PatientOperationRepository patientOperationRepository) {
        this.patientOperationRepository = patientOperationRepository;
    }
}
