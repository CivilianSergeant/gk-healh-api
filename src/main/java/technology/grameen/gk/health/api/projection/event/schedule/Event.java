package technology.grameen.gk.health.api.projection.event.schedule;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private Long empId;
    private String doctor;
    private List<LocalDateTime> dates;

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

    public List<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(List<LocalDateTime> dates) {
        this.dates = dates;
    }
}
