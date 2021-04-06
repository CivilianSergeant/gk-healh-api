package technology.grameen.gk.health.api.services.invoice;

import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.projection.PatientInvoiceAutoComplete;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.*;
import technology.grameen.gk.health.api.repositories.PatientInvoiceRepository;
import technology.grameen.gk.health.api.repositories.PatientServiceRepository;
import technology.grameen.gk.health.api.services.card_registration.CardRegistrationService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.springframework.stereotype.Service
public class PatientInvoiceServiceImpl implements PatientInvoiceService {

    private PatientInvoiceRepository invoiceRepository;
    private PatientServiceRepository patientServiceRepository;
    private CardRegistrationService cardRegistrationService;
    private boolean patientNotFound = false;
    private String patientNotFoundMessage = null;

    PatientInvoiceServiceImpl(PatientInvoiceRepository invoiceRepository,
                              PatientServiceRepository patientServiceRepository,
                              CardRegistrationService cardRegistrationService){

        this.invoiceRepository = invoiceRepository;
        this.patientServiceRepository = patientServiceRepository;
        this.cardRegistrationService = cardRegistrationService;
    }

    @Override
    public Optional<PatientInvoiceDetail> getInvoiceById(Long id) {
        return invoiceRepository.findByInvoiceId(id);
    }

    @Override
    public List<PatientInvoiceAutoComplete> getInvoiceByNumber(String number) {
        return invoiceRepository.findByInvoiceNumberContaining(number);
    }

    @Override
    @Transactional
    public Boolean createInvoice(Patient patient) throws Exception {
        this.patientNotFound = false;
        PatientInvoice patientInvoice = patient.getPatientInvoices()
                    .stream().filter(invoice-> invoice.getId()==null)
                            .findAny().orElse(null);

        int maxInvoiceId = (invoiceRepository.getMaxInvoiceId()!=null)? invoiceRepository.getMaxInvoiceId()+1 : 1;
        String invoiceId = "INV-"+patient.getPid()+"-"+((maxInvoiceId<9)? "0"+maxInvoiceId : maxInvoiceId);
        patientInvoice.setInvoiceNumber(invoiceId);

        HealthCenter center = patient.getCenter();
        Employee employee = patient.getCreatedBy();

        center.addPatientInvoices(patientInvoice);
        patient.addPatientInvoices(patientInvoice);

        employee.addPatientInvoice(patientInvoice);

        invoiceRepository.save(patientInvoice);

        if(patientInvoice.getId()>0){

            Set<PatientServiceDetail> patientServiceDetails = patientInvoice.getPatientServiceDetails();
            patientServiceDetails.stream().forEach(patientServiceDetail->{

                patientServiceDetail.setServiceQty(1);
                patientServiceDetail.setReportGenerated(false);
                Service service = patientServiceDetail.getService();
                service.addPatientService(patientServiceDetail);
                patientInvoice.addPatientServiceDetail(patientServiceDetail);
                patientServiceRepository.save(patientServiceDetail);

                if(patientServiceDetail.getService().getCode().contains("card") ||
                        patientServiceDetail.getService().getCode().contains("card registration") ){

                    try {
                        cardRegistrationService.register(patient);
                    } catch (Exception e) {
                        this.patientNotFound = true;
                        this.patientNotFoundMessage = e.getMessage();
                        return;
                    }
                }
            });

            if(this.patientNotFound){
                throw new Exception(this.patientNotFoundMessage);
            }

        }

        return true;
    }

    @Override
    public Optional<PatientServiceDetail> getPatientServiceDetailByInvoiceAndService(
                            PatientInvoice patientInvoice, Service service) {
        return patientServiceRepository.findByPatientInvoiceAndService(patientInvoice,service);
    }

    @Override
    public PatientServiceDetail updatePatientServiceDetail(PatientServiceDetail patientServiceDetail) {
        return patientServiceRepository.save(patientServiceDetail);
    }
}
