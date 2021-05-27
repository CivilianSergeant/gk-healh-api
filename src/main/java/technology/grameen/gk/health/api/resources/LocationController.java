package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.IResponse;
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

    @GetMapping("/villages/{unionCode}")
    public ResponseEntity<IResponse> villages(@PathVariable("unionCode") String unionCode){
        return new ResponseEntity<>(new EntityCollectionResponse<>(
                HttpStatus.OK.value(),
                locationService.getVillageList(unionCode)
        ),HttpStatus.OK);
    }


}
