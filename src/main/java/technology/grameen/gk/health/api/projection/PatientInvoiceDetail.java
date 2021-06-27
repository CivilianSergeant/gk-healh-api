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
    BigDecimal getPayableAmount();

    interface CardMemberCardRegistration{
        Long getId();
        Boolean getGB();

        String getCardNumber();
        Integer getValidityDuration();
        Integer getTotalServiceTaken();
        Boolean getActive();
        LocalDateTime getStartDate();
        LocalDateTime getExpiredDate();
    }

    interface CardMember{
        Long getId();
        String getFullName();
        CardMemberCardRegistration getCardRegistration();
        Patient getPatient();

    }

    interface CardRegistration{
        Long getId();
        Boolean getActive();
        String getCardNumber();

        Boolean getGB();
        Integer getValidityDuration();

        Integer getTotalServiceTaken();
        LocalDateTime getStartDate();
        LocalDateTime getExpiredDate();
        void setActive(Boolean active);
    }





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

    interface ServiceCategory{
        Long getId();
        String getName();
    }

    interface Service{
        Long getServiceId();
        String getName();
        Boolean getLabTest();
        ServiceCategory getServiceCategory();
    }

    interface PatientServiceDetail{
        Long getId();
        Service getService();
        Integer getRoomNumber();
        Integer getServiceQty();
        BigDecimal getServiceAmount();
        BigDecimal getDiscountAmount();
        BigDecimal getPayableAmount();
        LocalDateTime getCreatedAt();
        LocalDateTime getLastUpdatedAt();
        Boolean getReportGenerated();
    }

    Patient getPatient();

    Set<PatientServiceDetail> getPatientServiceDetails();


}



