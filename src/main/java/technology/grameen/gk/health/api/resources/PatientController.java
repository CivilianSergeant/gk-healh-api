package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.CardMember;
import technology.grameen.gk.health.api.entity.Patient;
import technology.grameen.gk.health.api.projection.PatientSearchResult;
import technology.grameen.gk.health.api.projection.PatientNumberAutoComplete;
import technology.grameen.gk.health.api.requests.PatientRequest;
import technology.grameen.gk.health.api.requests.PatientSearch;
import technology.grameen.gk.health.api.responses.*;
import technology.grameen.gk.health.api.services.PatientManageService;
import technology.grameen.gk.health.api.services.card_registration.CardMemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

    private PatientManageService patientManageService;
    private CardMemberService cardMemberService;

    PatientController(PatientManageService patientManageService, CardMemberService cardMemberService){
       this.patientManageService = patientManageService;
       this.cardMemberService = cardMemberService;
    }



    @RequestMapping(value = "/{id}")
    public ResponseEntity<Optional<PatientSearchResult>> findById(@PathVariable("id") Long id){

        return new ResponseEntity<>(patientManageService.getPatientById(id), HttpStatus.OK);
    }

//    @RequestMapping(value = "")
//    public ResponseEntity<Page<PatientListItem>> list(@Param("page") Integer page,@Param("size") Integer size){
//        if(page==null){
//            page=0;
//        }
//        if(size==null){
//            size=20;
//        }
//        Pageable pageable = PageRequest.of(page,size);
//        return new ResponseEntity<>(patientManageService.getPatients(pageable), HttpStatus.OK);
//    }

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

    @PostMapping(value = "/add/from-member")
    public ResponseEntity<IResponse>addPatientFromMember(@RequestBody CardMember cardMember){
        try {

            Patient newPatient = patientManageService.addPatient(new PatientRequest(cardMember.getPatient()));
            cardMember.setPatient(newPatient);
            cardMemberService.updateMember(cardMember);
            return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(),cardMember), HttpStatus.OK);
        }catch (Exception ex){

            return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    ex.getMessage()),HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @GetMapping("/patient-ids/{patientNumber}")
    public ResponseEntity<IResponse> getByPatientNumber(@PathVariable("patientNumber") String pid){
        List<PatientNumberAutoComplete> pids = patientManageService.getPatientIds(pid);
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(),
                pids),HttpStatus.OK);
    }

    @GetMapping(value = "/by-pid/{pid}")
    public ResponseEntity<IResponse> getPatientByPID(@PathVariable("pid") String pid){
        Optional<PatientSearchResult> patient = patientManageService.getPatientByPId(pid);

        if(patient.isPresent()){
            return new ResponseEntity<>(new PatientCreationResponse(HttpStatus.OK.value(),patient.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ExceptionResponse(422,"No Patient found"), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getPatientsBySearch(@RequestParam Optional<Long> centerId,
                                                         @RequestParam Optional<String> field,
                                                         @RequestParam Optional<String> value,
                                                         @RequestParam Optional<Integer> page,
                                                         @RequestParam Optional<Integer> size,
                                                         @RequestParam Optional<String> sortBy,
                                                         @RequestParam Optional<Boolean> sortDesc){

        String _sortBy = sortBy.orElse(null);

        Sort sort = null;

        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }

        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(5),sort) :
                 PageRequest.of(page.orElse(0),size.orElse(5));

        return new ResponseEntity<>(new EntityResponse(HttpStatus.OK.value(),
                patientManageService.getPatientsBySearch(centerId.orElse(null),
                                field.orElse(null), value.orElse(null), pageable)),
                                    HttpStatus.OK);
    }
}
