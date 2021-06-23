package technology.grameen.gk.health.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.projection.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientInvoiceAutoComplete;
import technology.grameen.gk.health.api.projection.PatientSearchResult;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.PatientManageService;
import technology.grameen.gk.health.api.services.invoice.PatientInvoiceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoice")
public class PatientInvoiceController {

    @Autowired
    private PatientInvoiceService patientInvoiceService;

    @Autowired
    private PatientManageService patientManageService;

    @GetMapping("/invoice-numbers/{invoiceNumber}")
    public ResponseEntity<IResponse> getByInvoiceNumber(@PathVariable("invoiceNumber") String invoiceNumber){
        List<PatientInvoiceAutoComplete> invoiceNumbers = patientInvoiceService.getInvoiceByNumber(invoiceNumber);
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                invoiceNumbers),HttpStatus.OK);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Optional<PatientInvoiceDetail>> getByInvoiceId(@PathVariable("id") Long invoiceId){
        return new ResponseEntity<>(patientInvoiceService.getInvoiceById(invoiceId),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<IResponse> createInvoice(@RequestBody Patient patient){
        try {
            Optional<PatientSearchResult> patient1 = null;
            Boolean created = patientInvoiceService.createInvoice(patient);
            if(created){
                patient1 = patientManageService.getPatientByPId(patient.getPid());
            }
            return new ResponseEntity<>(new EntityResponse<PatientSearchResult>(HttpStatus.OK.value(),patient1.get()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/prescription-invoice-numbers")
    public ResponseEntity<IResponse> getPrescriptionInvoice(){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                patientInvoiceService.getPrescriptionInvoiceByNumber()
        ),HttpStatus.OK);
    }

    @GetMapping("/total-unposted-amount")
    public ResponseEntity<IResponse> getTotalUnPostedAmount(){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                patientInvoiceService.getTotalUnPostedAmount()
        ), HttpStatus.OK);
    }
}
