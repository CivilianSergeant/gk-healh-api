package technology.grameen.gk.health.api.projection.event.schedule;

import java.util.ArrayList;
import java.util.List;

public class EventCategory {
    private Integer id;
    private String name;
    private List<Event> events = new ArrayList<>();

    public EventCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvents(Event event) {
        this.events.add(event);
    }
}
