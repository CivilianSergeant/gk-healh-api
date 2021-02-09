package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.requests.PatientRequest;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

    private PatientManageService patientManageService;

    PatientController(PatientManageService patientManageService){
       this.patientManageService = patientManageService;
    }

    @RequestMapping(value = "")
    public ResponseEntity<List<Patient>> list(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/add")
    public ResponseEntity<Patient> addPatient(@RequestBody PatientRequest patient){
        Patient newPatient = patientManageService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.OK);
    }
}
