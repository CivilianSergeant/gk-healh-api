package technology.grameen.gk.health.api.projection;

import java.time.LocalDateTime;

public interface PrescriptionListItem {

    Long getId();
    Long getPrescriptionId();
    String getpNumber();
    LocalDateTime getCreatedAt();
    String getFullName();
}
