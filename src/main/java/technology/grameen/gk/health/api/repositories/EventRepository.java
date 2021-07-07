package technology.grameen.gk.health.api.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    interface EventItem{
            Long getId();
            String getCenter();

            @JsonFormat(pattern = "yyyy-MM-dd")
            LocalDateTime getEventDate();
            String getEventCategory();
            String getEventType();
            String getDoctor();
            String getStatus();
    }

    @Query(value = "SELECT e.id, hc.NAME as center , e.event_date as eventDate, ec.NAME as eventCategory , " +
            "e.EVENT_TYPE as eventType, e2.FULL_NAME as doctor, e.status FROM Events e\n" +
            "JOIN EVENT_PERSONNEL ep ON ep.EVENT_ID = e.ID \n" +
            "JOIN EMPLOYEES e2 ON e2.ID  = ep.EMPLOYEE_ID \n" +
            "JOIN HEALTH_CENTERS hc ON hc.ID = e.CENTER_ID \n" +
            "JOIN EVENT_CATEGORIES ec ON ec.ID  = e.EVENT_CATEGORY_ID \n" +
            "JOIN LG_VILLAGES lv ON lv.LG_VILLAGE_ID  = e.VILLAGE_LG_VILLAGE_ID",
    countQuery = "SELECT count(*) FROM Events e",nativeQuery = true)
    Page<EventItem> findAllEvents(Pageable pageable);
}
