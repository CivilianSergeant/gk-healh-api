package technology.grameen.gk.health.api.services.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.EventCategory;
import technology.grameen.gk.health.api.repositories.EventCategoryRepository;

import java.util.List;
import java.util.Optional;

public interface EventCategoryService {

    EventCategory addEventCategory(EventCategory eventCategory);

    Page<EventCategory> getEventCategories(String name, Pageable pageable);
    List<EventCategory> getEventCategories();

    Optional<EventCategoryRepository.EventCategoryDetail> getById(Integer id);
}
