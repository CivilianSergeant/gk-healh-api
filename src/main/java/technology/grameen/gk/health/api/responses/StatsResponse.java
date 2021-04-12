package technology.grameen.gk.health.api.responses;

import java.math.BigDecimal;

public class StatsResponse implements  IResponse{

    private Integer totalPatient;
    private Integer totalGbPatient;
    private Integer totalNonGbPatient;
    private BigDecimal totalAmount;

    public StatsResponse(Integer totalPatient, Integer totalGbPatient, Integer totalNonGbPatient, BigDecimal totalAmount) {
        this.totalPatient = totalPatient;
        this.totalGbPatient = totalGbPatient;
        this.totalNonGbPatient = totalNonGbPatient;
        this.totalAmount = totalAmount;
    }

    public Integer getTotalPatient() {
        return totalPatient;
    }

    public void setTotalPatient(Integer totalPatient) {
        this.totalPatient = totalPatient;
    }

    public Integer getTotalGbPatient() {
        return totalGbPatient;
    }

    public void setTotalGbPatient(Integer totalGbPatient) {
        this.totalGbPatient = totalGbPatient;
    }

    public Integer getTotalNonGbPatient() {
        return totalNonGbPatient;
    }

    public void setTotalNonGbPatient(Integer totalNonGbPatient) {
        this.totalNonGbPatient = totalNonGbPatient;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
