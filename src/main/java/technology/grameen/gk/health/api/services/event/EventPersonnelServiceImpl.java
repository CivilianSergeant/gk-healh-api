package technology.grameen.gk.health.api.services.event;

import technology.grameen.gk.health.api.repositories.EventPersonnelRepository;

public class EventPersonnelServiceImpl implements EventPersonnelService{

    private EventPersonnelRepository eventPersonnelRepository;

    public EventPersonnelServiceImpl(EventPersonnelRepository eventPersonnelRepository) {
        this.eventPersonnelRepository = eventPersonnelRepository;
    }
}
