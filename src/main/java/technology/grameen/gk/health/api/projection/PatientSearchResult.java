package technology.grameen.gk.health.api.projection;

import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.PatientInvoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public interface PatientSearchResult {

        interface Service{
                Long getServiceId();
                String getName();

        }

        interface PatientServiceDetail{
                Long getId();
                Service getService();
                Integer getServiceQty();
                Integer getRoomNumber();
                BigDecimal getServiceAmount();
                BigDecimal getDiscountAmount();
                BigDecimal getPayableAmount();
                LocalDateTime getCreatedAt();
        }

        interface PatientInvoice{
                String getInvoiceNumber();
                Set<PatientServiceDetail> getPatientServiceDetails();
                BigDecimal getServiceAmount();
                BigDecimal getDiscountAmount();
                BigDecimal getPayableAmount();
                BigDecimal getPaidAmount();
                BigDecimal getDueAmount();
                LocalDateTime getCreatedAt();
        }

        interface Patient{
                String getFullName();
                String getPid();
        }

        interface CardMemberCardRegistration{
                String getCardNumber();
                Patient getPatient();
        }

        interface CardMember{
                Long getId();
                CardMemberCardRegistration getCardRegistration();

        }



        Long getId();
        String getPid();
        String getFullName();
        String getGuardianName();
        String getMotherName();
        String getGender();
        String getMobileNumber();
        String getAge();
        CardRegistration getRegistration();
        Set<PatientInvoice> getPatientInvoices();
        CardMember getCardMember();

}
