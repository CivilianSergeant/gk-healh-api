package technology.grameen.gk.health.api.services.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.Event;
import technology.grameen.gk.health.api.repositories.EventRepository;
import technology.grameen.gk.health.api.requests.EventRequest;

public interface EventService {

    final static String CAMP="camp";
    final static String SATELLITE="satellite";
    final static String SCHOOL="school";

    Event addEvent(EventRequest event);

    Page<EventRepository.EventItem> getEvents(Pageable pageable);
}
