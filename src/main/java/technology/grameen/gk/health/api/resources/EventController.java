package technology.grameen.gk.health.api.resources;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gk.health.api.entity.Event;
import technology.grameen.gk.health.api.exceptions.CustomException;
import technology.grameen.gk.health.api.requests.EventRequest;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.services.event.EventService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    private static final Integer PAGE_SIZE = 10;
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<IResponse> addEvent(@RequestBody EventRequest event) throws CustomException {
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                eventService.addEvent(event)
        ), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<IResponse> getEvents(@RequestParam Optional<Integer> page,
                                               @RequestParam Optional<Integer> size,
                                               @RequestParam Optional<String> sortBy,
                                               @RequestParam Optional<Boolean> sortDesc){

        String _sortBy = sortBy.orElse(null);

        Sort sort = null;

        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));


        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                eventService.getEvents(pageable)
        ), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<IResponse> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(new EntityResponse<>(
                HttpStatus.OK.value(),
                eventService.getEventById(id)
        ), HttpStatus.OK);
    }
}
