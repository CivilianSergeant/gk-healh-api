package technology.grameen.gk.health.api.services.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Event;
import technology.grameen.gk.health.api.entity.EventPersonnel;
import technology.grameen.gk.health.api.repositories.EventRepository;
import technology.grameen.gk.health.api.requests.EventRequest;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;
    private EventPersonnelService eventPersonnelService;

    public EventServiceImpl(EventRepository eventRepository, EventPersonnelService eventPersonnelService) {
        this.eventRepository = eventRepository;
        this.eventPersonnelService = eventPersonnelService;
    }

    @Override
    public Page<EventRepository.EventItem> getEvents(Pageable pageable) {
        return eventRepository.findAllEvents(pageable);
    }

    @Override
    @Transactional
    public Event addEvent(EventRequest er) {
        Event event = er.getEvent();
        EventPersonnel eventPersonnel = er.getEventPersonnel();
        eventRepository.save(event);
        eventPersonnel.setEvent(event);
        eventPersonnelService.addEventPersonnel(eventPersonnel);
        return event;
    }
}
