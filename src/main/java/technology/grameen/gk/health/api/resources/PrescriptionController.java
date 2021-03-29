package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.entity.PatientInvoice;
import technology.grameen.gk.health.api.entity.Prescription;
import technology.grameen.gk.health.api.projection.PrescriptionListItem;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.prescription.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prescription")
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    PrescriptionController(PrescriptionService prescriptionService){
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> addPrescription(@RequestBody Prescription prescription){
        Prescription newPrescription = prescriptionService.savePrescription(prescription);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),newPrescription), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getPrescriptions(){
        List<PrescriptionListItem> prescriptions = prescriptionService.getPrescriptions();
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),prescriptions),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getPrescriptionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),
                prescriptionService.getPrescriptionById(id)),HttpStatus.OK);
    }

    @GetMapping("/{patientId}/{invoiceId}")
    public ResponseEntity<IResponse> getPrescriptionById(@PathVariable("patientId") Long patientId,
                                                         @PathVariable("invoiceId") Long invoiceId){
        Patient patient = new Patient();
        PatientInvoice patientInvoice = new PatientInvoice();
        patient.setId(patientId);
        patientInvoice.setId(invoiceId);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),

                prescriptionService.getPrescriptionByPatientAndInvoice(patient,patientInvoice)),HttpStatus.OK);
    }
}
