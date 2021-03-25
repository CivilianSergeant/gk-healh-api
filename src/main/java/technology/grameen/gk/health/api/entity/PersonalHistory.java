package technology.grameen.gk.health.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "personal_histories")
public class PersonalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Prescription prescription;

    private Boolean dm;
    private Boolean htn;
    private Boolean tb;
    private Boolean asthma;
    private Boolean pud;
    private String previousHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Boolean getDm() {
        return dm;
    }

    public void setDm(Boolean dm) {
        this.dm = dm;
    }

    public Boolean getHtn() {
        return htn;
    }

    public void setHtn(Boolean htn) {
        this.htn = htn;
    }

    public Boolean getTb() {
        return tb;
    }

    public void setTb(Boolean tb) {
        this.tb = tb;
    }

    public Boolean getAsthma() {
        return asthma;
    }

    public void setAsthma(Boolean asthma) {
        this.asthma = asthma;
    }

    public Boolean getPud() {
        return pud;
    }

    public void setPud(Boolean pud) {
        this.pud = pud;
    }

    public String getPreviousHistory() {
        return previousHistory;
    }

    public void setPreviousHistory(String previousHistory) {
        this.previousHistory = previousHistory;
    }
}
