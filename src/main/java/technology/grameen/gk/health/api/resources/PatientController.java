package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.requests.PatientRequest;
import technology.grameen.gk.health.api.responses.ExceptionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.responses.PatientCreationResponse;
import technology.grameen.gk.health.api.services.PatientManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

    private PatientManageService patientManageService;

    PatientController(PatientManageService patientManageService){
       this.patientManageService = patientManageService;
    }



    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<Patient>> findById(@PathVariable("id") Long id){

        return new ResponseEntity<>(patientManageService.getPatientById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "")
    public ResponseEntity<Page<Patient>> list(@Param("page") Integer page,@Param("size") Integer size){
        if(page==null){
            page=0;
        }
        if(size==null){
            size=20;
        }
        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<>(patientManageService.getPatients(pageable), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<IResponse>addPatient(@RequestBody PatientRequest patient){
        try {
            Patient newPatient = patientManageService.addPatient(patient);
            return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.OK.value(),newPatient), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    ex.getMessage()),HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @GetMapping(value = "/by-pid/{pid}")
    public ResponseEntity<IResponse> getPatientByPID(@PathVariable("pid") String pid){
        Optional<Patient> patient = patientManageService.getPatientByPId(pid);
        if(patient.isPresent()){
            return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.OK.value(),patient.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ExceptionResponse(422,"No Patient found"), HttpStatus.OK);
    }

    @PostMapping(value = "/card-registration")
    public ResponseEntity<IResponse> registerPatient(@RequestBody CardRegistration cardRegistration){
        try {
            Optional<Patient> patient = Optional.ofNullable(patientManageService.cardRegister(cardRegistration));
            if(patient.isPresent()){
                return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.OK.value(),patient.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),"No Patient found"), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    ex.getMessage()),HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
