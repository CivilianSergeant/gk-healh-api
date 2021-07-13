package technology.grameen.gk.health.api.projection.event.schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private Long empId;
    private String doctor;
    private List<String> dates = new ArrayList<>();

    public Event(Long empId, String doctor) {
        this.empId = empId;
        this.doctor = doctor;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public List<String> getDates() {
        return dates;
    }

    public void addDate(String date) {
        this.dates.add(date);
    }
}
