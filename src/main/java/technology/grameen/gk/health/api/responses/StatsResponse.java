package technology.grameen.gk.health.api.responses;

import java.math.BigDecimal;

public class StatsResponse implements  IResponse{

    private Integer totalPatient;
    private Integer totalGbPatient;
    private Integer totalNonGbPatient;
    private BigDecimal totalAmount;
    private BigDecimal totalAmountUptoLastDay;
    private Integer totalPatientUptoLastDay;
    private Integer totalGbPatientUptoLastDay;
    private Integer totalNonGbPatientUptoLastDay;

    public StatsResponse(Integer totalPatient, Integer totalGbPatient, Integer totalNonGbPatient, BigDecimal totalAmount,
                         BigDecimal totalAmountUptoLastDay,
                         Integer totalPatientUptoLastDay,
                         Integer totalGbPatientUptoLastDay,
                         Integer totalNonGbPatientUptoLastDay) {
        this.totalPatient = totalPatient;
        this.totalGbPatient = totalGbPatient;
        this.totalNonGbPatient = totalNonGbPatient;
        this.totalAmount = totalAmount;
        this.totalAmountUptoLastDay = totalAmountUptoLastDay;
        this.totalPatientUptoLastDay = totalPatientUptoLastDay;
        this.totalGbPatientUptoLastDay = totalGbPatientUptoLastDay;
        this.totalNonGbPatientUptoLastDay = totalNonGbPatientUptoLastDay;

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

    public BigDecimal getTotalAmountUptoLastDay() {
        return totalAmountUptoLastDay;
    }

    public void setTotalAmountUptoLastDay(BigDecimal totalAmountUptoLastDay) {
        this.totalAmountUptoLastDay = totalAmountUptoLastDay;
    }

    public Integer getTotalPatientUptoLastDay() {
        return totalPatientUptoLastDay;
    }

    public void setTotalPatientUptoLastDay(Integer totalPatientUptoLastDay) {
        this.totalPatientUptoLastDay = totalPatientUptoLastDay;
    }

    public Integer getTotalGbPatientUptoLastDay() {
        return totalGbPatientUptoLastDay;
    }

    public void setTotalGbPatientUptoLastDay(Integer totalGbPatientUptoLastDay) {
        this.totalGbPatientUptoLastDay = totalGbPatientUptoLastDay;
    }

    public Integer getTotalNonGbPatientUptoLastDay() {
        return totalNonGbPatientUptoLastDay;
    }

    public void setTotalNonGbPatientUptoLastDay(Integer totalNonGbPatientUptoLastDay) {
        this.totalNonGbPatientUptoLastDay = totalNonGbPatientUptoLastDay;
    }
}
