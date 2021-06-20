package technology.grameen.gk.health.api.services.event;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService{

    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
