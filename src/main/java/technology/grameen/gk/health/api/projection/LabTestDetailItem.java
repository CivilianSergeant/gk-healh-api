package technology.grameen.gk.health.api.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public interface LabTestDetailItem {

    interface CardRegistration{
        Long getId();
        Boolean getGB();
    }

    interface CardMember{
        Long getId();
        CardRegistration getCardRegistration();

    }

    interface Patient{
        Long getId();
        String getFullName();
        String getPid();
        String getAge();
        String getGender();
        Boolean getGB();
        CardRegistration getRegistration();
        CardMember getCardMember();
    }

    interface PatientInvoice{
        Long getId();
        String getInvoiceNumber();
        LocalDateTime getCreatedAt();
    }

    interface LabTestUnit{
        Long getId();
        String getName();
    }

    interface LabTestAttribute{
        Long getId();
        LabTestUnit getLabTestUnit();
        String getAttributeName();
        String getAverageRange();
        String getMaleRange();
        String getFemaleRange();
        String getChildRange();
        Integer getDisplayOrder();
        Boolean getActive();
        Boolean getGroup();
    }

    interface LabTestReportDetail{
        Long getId();
        LabTestAttribute getLabTestAttribute();
        String getResult();
    }

    interface  Specimen{
        Integer getId();
        String getName();
    }

    interface LabTestGroup{
        Integer getId();
        String getName();
    }

    interface Service{
        Long getServiceId();
        String getName();
    }

     Long getId();
     Patient getPatient();
     PatientInvoice getPatientInvoice();
     Specimen getSpecimen();
     LabTestGroup getLabTestGroup();
     Service getService();
     Set<LabTestReportDetail> getDetails();
     LocalDateTime getCreatedAt();
     LocalDate getDeliveryDate();
     String getStatus();

}
