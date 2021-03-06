package technology.grameen.gk.health.api.services.prescription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.projection.PrescriptionDetail;
import technology.grameen.gk.health.api.projection.PrescriptionListItem;
import technology.grameen.gk.health.api.repositories.*;
import technology.grameen.gk.health.api.services.invoice.PatientInvoiceService;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private PrescriptionRepository prescriptionRepository;
    private FamilyHistoryRepository familyHistoryRepository;
    private PersonalHistoryRepository personalHistoryRepository;
    private GeneralExaminationRepository generalExaminationRepository;
    private RecommendedTestRepository recommendedTestRepository;
    private RecommendedMedicineRepository recommendedMedicineRepository;
    private PatientInvoiceService patientInvoiceService;

    PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository,
                            FamilyHistoryRepository familyHistoryRepository,
                            PersonalHistoryRepository personalHistoryRepository,
                            GeneralExaminationRepository generalExaminationRepository,
                            RecommendedTestRepository recommendedTestRepository,
                            RecommendedMedicineRepository recommendedMedicineRepository,
                            PatientInvoiceService patientInvoiceService){

        this.prescriptionRepository = prescriptionRepository;
        this.familyHistoryRepository = familyHistoryRepository;
        this.personalHistoryRepository = personalHistoryRepository;
        this.generalExaminationRepository = generalExaminationRepository;
        this.recommendedTestRepository = recommendedTestRepository;
        this.recommendedMedicineRepository = recommendedMedicineRepository;
        this.patientInvoiceService = patientInvoiceService;
    }

    @Override
    @Transactional
    public Prescription savePrescription(Prescription prescription) {




        Prescription newPrescription = prescriptionRepository.save(prescription);

        newPrescription.setpNumber(getPrescriptionNumber(prescription.getCenter()));
        FamilyHistory familyHistory = prescription.getFamilyHistory();
        PersonalHistory personalHistory = prescription.getPersonalHistory();
        GeneralExamination generalExamination = prescription.getGeneralExamination();
        familyHistory.setPrescription(prescription);
        personalHistory.setPrescription(prescription);
        generalExamination.setPrescription(prescription);

        if(newPrescription.getId()>0) {



            familyHistoryRepository.save(familyHistory);
            personalHistoryRepository.save(personalHistory);
            generalExaminationRepository.save(generalExamination);

            if (prescription.getRecommendedTests().size() > 0) {
                prescription.getRecommendedTests().stream()
                        .map((recommendedTest) -> {
                            recommendedTest.setPrescription(prescription);
                            return recommendedTest;
                        }).collect(Collectors.toSet());
                recommendedTestRepository.saveAll(prescription.getRecommendedTests());
            }

            if (prescription.getRecommendedMedicines().size() > 0) {
                prescription.getRecommendedMedicines().stream()
                        .map((recommendedMedicine) -> {
                            recommendedMedicine.setPrescription(prescription);
                            return recommendedMedicine;
                        }).collect(Collectors.toSet());

                recommendedMedicineRepository.saveAll(prescription.getRecommendedMedicines());
            }


            Optional<PatientServiceDetail> _patientServiceDetail=null;

            _patientServiceDetail = patientInvoiceService
                    .getPrescriptionServiceDetailByPatientInvoice(prescription.getPatientInvoice());
            if(_patientServiceDetail != null && _patientServiceDetail.isPresent()) {
                PatientServiceDetail patientServiceDetail = _patientServiceDetail.get();
                patientServiceDetail.setReportGenerated(true);
                patientInvoiceService.updatePatientServiceDetail(patientServiceDetail);
            }

        }

        return newPrescription;
    }

    @Override
    public Page<PrescriptionListItem> getPrescriptions(Pageable pageable) {
        return prescriptionRepository.findAllPrescriptions(pageable);
    }

    @Override
    public Page<PrescriptionListItem> getPrescriptions(String pNumber, String fullName, String date, Pageable pageable) {
        if(pNumber.isEmpty() && fullName.isEmpty() && date.isEmpty()){
            return prescriptionRepository.findAllPrescriptions(pageable);
        }
        if(!pNumber.isEmpty() && fullName.isEmpty() && date.isEmpty()){
            return prescriptionRepository.findAllPrescriptionsByPNumber(pNumber,pageable);
        }
        if(pNumber.isEmpty() && !fullName.isEmpty() && date.isEmpty()){
            return prescriptionRepository.findAllPrescriptionsByFullName(fullName,pageable);
        }
        if(pNumber.isEmpty() && fullName.isEmpty() && !date.isEmpty()){
            return prescriptionRepository.findAllPrescriptionsByDate(date,pageable);
        }
        return prescriptionRepository.findAllPrescriptions(pNumber, fullName, date, pageable);
    }

    String getPrescriptionNumber(HealthCenter center){
        Calendar calendar = Calendar.getInstance();
        int year = (calendar.get(Calendar.YEAR));
        int month = (calendar.get(Calendar.MONTH));
        int date = (calendar.get(Calendar.DATE));

        return center.getCenterCode()+"-"+ year + (((month+1)<10)? "0"+(month+1) :
                (month+1)) + ((date<10)? "0"+date : date);
    }

    @Override
    public Optional<PrescriptionDetail> getPrescriptionById(Long id) {
        return prescriptionRepository.findByPatientId(id);
    }

    @Override
    public Optional<PrescriptionDetail> getPrescriptionByPatientAndInvoice(Patient patientId, PatientInvoice invoiceId) {
        return prescriptionRepository.findByPrescriptionPatientAndPatientInvoice(patientId, invoiceId);
    }
}
