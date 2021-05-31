package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.Medicine;
import technology.grameen.gk.health.api.entity.Village;
import technology.grameen.gk.health.api.requests.LocationMappingRequest;
import technology.grameen.gk.health.api.responses.*;
import technology.grameen.gk.health.api.services.LocationService;

@RestController
@RequestMapping(value = "/api/v1/location")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/divisions")
    public ResponseEntity<IResponse> divisions(){
       return new ResponseEntity<>(new EntityCollectionResponse<>(
               HttpStatus.OK.value(),
               locationService.getDivisionList()
       ),HttpStatus.OK);
    }

    @GetMapping("/districts/{divisionId}")
    public ResponseEntity<IResponse> districts(@PathVariable("divisionId") Long divisionId){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                locationService.getDistrictList(divisionId)
        ),HttpStatus.OK);
    }

    @GetMapping("/thanas/{districtId}")
    public ResponseEntity<IResponse> thanas(@PathVariable("districtId") Long districtId){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                locationService.getThanaList(districtId)
        ),HttpStatus.OK);
    }

    @GetMapping("/unions/{thanaId}")
    public ResponseEntity<IResponse> unions(@PathVariable("thanaId") Long thanaId){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                locationService.getUnionList(thanaId)
        ),HttpStatus.OK);
    }

    @GetMapping("/villages/{unionId}")
    public ResponseEntity<IResponse> villages(@PathVariable("unionId") Long unionId){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                locationService.getVillageList(unionId)
        ),HttpStatus.OK);
    }

    @PostMapping(value = "/mapping")
    public ResponseEntity<IResponse> mapping(@RequestBody LocationMappingRequest req){

        if(!locationService.villageMapping(req)){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                    "Mapping failed"),HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(new SimpleResponse(HttpStatus.OK.value(),
                "Successfully Mapped"),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<IResponse> addLocation(@RequestBody Village req){
        if(req.getVillageName().isEmpty()){
            return new ResponseEntity<>(new ExceptionResponse(HttpStatus.OK.value(), "Name is Required")
                    , HttpStatus.OK);
        }
        Village village = locationService.addLocation(req);
        return new ResponseEntity<>(new EntityResponse<>(HttpStatus.OK.value(), village), HttpStatus.OK);
    }




}
