package technology.grameen.gk.health.api.dto;

import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.PatientServiceDetail;

import java.time.LocalDateTime;
import java.util.Set;

public interface PatientInvoiceDetail {

    String getInvoiceNumber();

    interface Patient{

        Long getId();
        String getPid();
        String getFullName();
        String getGuardianName();
        String getMotherName();
        String getGender();
        String getMobileNumber();
        LocalDateTime getDateOfBirth();
        CardRegistration getRegistration();
    }

    Patient getPatient();

    Set<PatientServiceDetail> getPatientServiceDetails();


}



