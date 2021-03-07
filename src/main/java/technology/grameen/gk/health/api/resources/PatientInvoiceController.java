package technology.grameen.gk.health.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.dto.PatientInvoiceDetail;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.dto.PatientInvoiceAutoComplete;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.invoice.PatientInvoiceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoice")
public class PatientInvoiceController {

    @Autowired
    private PatientInvoiceService patientInvoiceService;

    @GetMapping("/invoice-numbers/{invoiceNumber}")
    public ResponseEntity<List<PatientInvoiceAutoComplete>> getByInvoiceNumber(@PathVariable("invoiceNumber") String invoiceNumber){
        return new ResponseEntity<>(patientInvoiceService.getInvoiceByNumber(invoiceNumber),HttpStatus.OK);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Optional<PatientInvoiceDetail>> getByInvoiceId(@PathVariable("id") Long invoiceId){
        return new ResponseEntity<>(patientInvoiceService.getInvoiceById(invoiceId),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<IResponse> createInvoice(@RequestBody Patient patient){
        try {
            patientInvoiceService.createInvoice(patient);
            return new ResponseEntity<>(new EntityResponse<Patient>(HttpStatus.OK.value(),patient), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
