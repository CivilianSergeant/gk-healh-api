package technology.grameen.gk.health.api.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VoucherSendRequest {

    public VoucherSendRequest(){}

    public VoucherSendRequest(Integer officeId, BigDecimal amount, String alias) {
        this.officeId = officeId;
        this.totalAmount = amount;
        this.alias = alias;
    }

    private Integer officeId;
    private String voucherNo;


    private LocalDateTime voucherDate;

    private BigDecimal totalAmount;
    private String alias;
    private String token;
    private String note;
    private String module;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public BigDecimal getAmount() {
        return totalAmount;
    }

    public void setAmount(BigDecimal amount) {
        this.totalAmount = amount;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public LocalDateTime getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(LocalDateTime voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
