package technology.grameen.gk.health.api.projection.event.schedule;

import java.util.List;

public class HealthCenter {
    private String name;
    private List<EventCategory> eventCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventCategory> getEventCategories() {
        return eventCategories;
    }

    public void setEventCategories(List<EventCategory> eventCategories) {
        this.eventCategories = eventCategories;
    }
}
