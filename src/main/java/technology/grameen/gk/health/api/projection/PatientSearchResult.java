package technology.grameen.gk.health.api.projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import technology.grameen.gk.health.api.entity.CardRegistration;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.PatientDetail;
import technology.grameen.gk.health.api.entity.PatientInvoice;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public interface PatientSearchResult {

        interface Village{
                Long getLgVillageId();
                String getVillageName();
        }

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

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

                @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
                Integer getValidityDuration();
                Set<CardMember> getMembers();
                Integer getTotalServiceTaken();

                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDateTime getStartDate();

                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDateTime getExpiredDate();
                void setActive(Boolean active);
        }

        interface CardMemberCardRegistration{
                Long getId();
                Boolean getGB();
                Patient getPatient();
                String getCardNumber();
                Integer getValidityDuration();
                Integer getTotalServiceTaken();
                Boolean getActive();

                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDateTime getStartDate();

                @JsonFormat(pattern = "yyyy-MM-dd")
                LocalDateTime getExpiredDate();
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
        Village getVillage();
        String getStreetAddress();
        String getGuardianName();
        String getMotherName();
        String getGender();
        String getMobileNumber();
        String getAge();
        CardRegistration getRegistration();
        void addRegistration(CardRegistration cardRegistration);
        Set<PatientInvoice> getPatientInvoices();
        CardMember getCardMember();
        String getMaritalStatus();
        PatientDetail getDetail();
        Boolean getGB();

}
