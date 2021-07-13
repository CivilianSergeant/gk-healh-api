package technology.grameen.gk.health.api.projection.event.schedule;

import java.util.ArrayList;
import java.util.List;

public class HCenter {
    private Long id;
    private String name;
    private List<EventCategory> eventCategories = new ArrayList<>();

    public HCenter(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventCategory> getEventCategories() {
        return eventCategories;
    }

    public void addEventCategories(EventCategory eventCategorie) {
        this.eventCategories.add(eventCategorie);
    }
}
