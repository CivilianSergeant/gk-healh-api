package technology.grameen.gk.health.api.services.event;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.EventPersonnel;
import technology.grameen.gk.health.api.repositories.EventPersonnelRepository;

@Service
public class EventPersonnelServiceImpl implements EventPersonnelService{

    private EventPersonnelRepository eventPersonnelRepository;

    public EventPersonnelServiceImpl(EventPersonnelRepository eventPersonnelRepository) {
        this.eventPersonnelRepository = eventPersonnelRepository;
    }

    @Override
    @Transactional
    public EventPersonnel addEventPersonnel(EventPersonnel eventPersonnel) {
        return eventPersonnelRepository.save(eventPersonnel);
    }
}
