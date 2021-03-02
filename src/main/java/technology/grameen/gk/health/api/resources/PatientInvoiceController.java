package technology.grameen.gk.health.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.IResponse;

@RestController
@RequestMapping("/api/v1/patient/invoice")
public class PatientInvoiceController {

    @PostMapping("/create")
    public ResponseEntity<IResponse> createInvoice(){

    }
}
