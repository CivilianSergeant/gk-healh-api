package technology.grameen.gk.health.api.projection;

import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.PatientServiceDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public interface PatientInvoiceDetail {

    Long getId();
    String getInvoiceNumber();
    BigDecimal getPaidAmount();

    interface Patient{

        Long getId();
        String getPid();
        String getFullName();
        String getGuardianName();
        String getMotherName();
        String getGender();
        String getMobileNumber();
        String getAge();
        CardRegistration getRegistration();
    }

    Patient getPatient();

    Set<PatientServiceDetail> getPatientServiceDetails();


}



