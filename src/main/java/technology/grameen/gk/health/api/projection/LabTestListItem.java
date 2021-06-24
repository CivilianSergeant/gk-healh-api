package technology.grameen.gk.health.api.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public interface LabTestListItem {

    String getFullName();
    Long getId();
    String getPid();
    String getInvoiceNumber();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getCreatedAt();
    String getServiceName();
    String getStatus();


}
