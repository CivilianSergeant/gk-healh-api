package technology.grameen.gk.health.api.requests;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gk.health.api.entity.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


public class PatientRequest {


    private Long id;
    private Long apiVillageId;
    private String village;
    private String pid;
    private String fullName;
    private String guardianName;
    private String motherName;
    private String gender;
    private String maritalStatus;
    private String mobileNumber;
    private String age;

    private HealthCenter center;

    private PatientDetail detail;

    private Employee createdBy;

    private CardRegistration cardRegistration;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiVillageId() {
        return apiVillageId;
    }

    public void setApiVillageId(Long apiVillageId) {
        this.apiVillageId = apiVillageId;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse(dateOfBirth, formatter);
        this.age = age;
    }

    public HealthCenter getCenter() {
        return center;
    }

    public void setCenter(HealthCenter center) {
        this.center = center;
    }

    public PatientDetail getDetail() {
        return detail;
    }

    public void setDetail(PatientDetail detail) {
        this.detail = detail;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public CardRegistration getCardRegistration() {
        return cardRegistration;
    }

    public void setCardRegistration(CardRegistration cardRegistration) {
        this.cardRegistration = cardRegistration;
    }
}
