package technology.grameen.gk.health.api.projection;

import java.time.LocalDate;

public interface LabTestListItem {

    String getFullName();
    Long getId();
    String getPid();
    String getInvoiceNumber();
    LocalDate getCreatedAt();
    String getServiceName();
    String getStatus();


}
