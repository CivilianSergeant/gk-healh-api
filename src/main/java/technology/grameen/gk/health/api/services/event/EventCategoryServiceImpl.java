package technology.grameen.gk.health.api.services.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.EventCategory;
import technology.grameen.gk.health.api.repositories.EventCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventCategoryServiceImpl implements EventCategoryService{

    private EventCategoryRepository eventCategoryRepository;

    public EventCategoryServiceImpl(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    @Override
    public EventCategory addEventCategory(EventCategory eventCategory) {
        return eventCategoryRepository.save(eventCategory);
    }

    @Override
    public Page<EventCategory> getEventCategories(String name, Pageable pageable) {
        if(name.isEmpty()){
            return eventCategoryRepository.findAll(pageable);
        }
        return eventCategoryRepository.findAllByName(name, pageable);
    }

    @Override
    public List<EventCategory> getEventCategories() {
        return eventCategoryRepository.findAll();
    }

    @Override
    public Optional<EventCategory> getById(Integer id) {
        return eventCategoryRepository.findById(id);
    }
}
