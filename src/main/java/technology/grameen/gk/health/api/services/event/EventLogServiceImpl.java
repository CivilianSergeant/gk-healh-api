package technology.grameen.gk.health.api.services.event;

import technology.grameen.gk.health.api.repositories.EventLogRepository;

public class EventLogServiceImpl implements EventLogService{

    private EventLogRepository eventLogRepository;

    public EventLogServiceImpl(EventLogRepository eventLogRepository) {
        this.eventLogRepository = eventLogRepository;
    }
}
