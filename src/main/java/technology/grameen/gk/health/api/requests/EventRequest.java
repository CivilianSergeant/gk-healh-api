package technology.grameen.gk.health.api.requests;

import technology.grameen.gk.health.api.entity.Event;
import technology.grameen.gk.health.api.entity.EventPersonnel;

public class EventRequest {
    private Event event;
    private EventPersonnel eventPersonnel;
    private Integer regionOfficeId;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventPersonnel getEventPersonnel() {
        return eventPersonnel;
    }

    public void setEventPersonnel(EventPersonnel eventPersonnel) {
        this.eventPersonnel = eventPersonnel;
    }

    public Integer getRegionOfficeId() {
        return regionOfficeId;
    }

    public void setRegionOfficeId(Integer regionOfficeId) {
        this.regionOfficeId = regionOfficeId;
    }
}
