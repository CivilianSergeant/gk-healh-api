package technology.grameen.gk.health.api.projection;

import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.PatientInvoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public interface PatientSearchResult {

        interface Service{
                Long getServiceId();
                String getName();
                Boolean getLabTest();
                Boolean getPrescription();
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
                Boolean getReportGenerated();
        }

        interface PatientInvoice{
                Long getId();
                String getInvoiceNumber();
                Set<PatientServiceDetail> getPatientServiceDetails();
                BigDecimal getServiceAmount();
                BigDecimal getDiscountAmount();
                BigDecimal getPayableAmount();
                BigDecimal getPaidAmount();
                BigDecimal getDueAmount();
                LocalDateTime getCreatedAt();
                HealthCenter getCenter();
        }

        interface Patient{
                String getFullName();
                String getPid();
        }

        interface CardRegistration{
                Long getId();
                Boolean getActive();
                String getCardNumber();
                Patient getPatient();
                Boolean getGB();
                Set<CardMember> getMembers();
        }

        interface CardMemberCardRegistration{
                Long getId();
                Boolean getGB();
                Patient getPatient();
                String getCardNumber();
        }

        interface CardMember{
                Long getId();
                String getFullName();
                CardMemberCardRegistration getCardRegistration();
                Patient getPatient();

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
