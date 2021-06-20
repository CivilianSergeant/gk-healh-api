package technology.grameen.gk.health.api.services.event;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.repositories.EventCategoryRepository;

@Service
public class EventCategoryServiceImpl implements EventCategoryService{

    private EventCategoryRepository eventCategoryRepository;

    public EventCategoryServiceImpl(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }
}
