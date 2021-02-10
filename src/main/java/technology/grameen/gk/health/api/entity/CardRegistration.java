package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "patient_registrations")
public class CardRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    /**
     *
     * 10 Digit Character
     * CenterCode(3)-Year(2)-month(2)-TotalPatientNo(6)
     */
    private String cardNumber;
    private Boolean isGB;
    private LocalDateTime startDate;
    private LocalDateTime expiredDate;
    private Boolean isActive;
    private Boolean isCardReceived;
    private LocalDateTime cardReceivedDate;
    private int totalServiceTaken;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean getGB() {
        return isGB;
    }

    public void setGB(Boolean GB) {
        isGB = GB;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getCardReceived() {
        return isCardReceived;
    }

    public void setCardReceived(Boolean cardReceived) {
        isCardReceived = cardReceived;
    }

    public LocalDateTime getCardReceivedDate() {
        return cardReceivedDate;
    }

    public void setCardReceivedDate(LocalDateTime cardReceivedDate) {
        this.cardReceivedDate = cardReceivedDate;
    }

    public int getTotalServiceTaken() {
        return totalServiceTaken;
    }

    public void setTotalServiceTaken(int totalServiceTaken) {
        this.totalServiceTaken = totalServiceTaken;
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
