package technology.grameen.gk.health.api.responses;

import java.time.LocalDateTime;

public class PatientListItem {

    private Long id;
    private String pid;
    private String fullName;
    private String gender;
    private String maritalStatus;
    private String age;
    private String center;
    private String guardianName;
    private String mobileNumber;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;

    public PatientListItem(Long id, String pid, String fullName, String gender, String maritalStatus,
                           String age, String center, String guardianName, String mobileNumber,
                           LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        this.id = id;
        this.pid = pid;
        this.fullName = fullName;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.age = age;
        this.center = center;
        this.guardianName = guardianName;
        this.mobileNumber = mobileNumber;
        this.createdAt = createdAt;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return age;
    }

    public void setDateOfBirth(String age) {
        this.age = age;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
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
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
