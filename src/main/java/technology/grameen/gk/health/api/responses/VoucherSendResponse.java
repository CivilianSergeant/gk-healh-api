package technology.grameen.gk.health.api.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

public class VoucherSendResponse  {
    private Voucher object;
    private Transaction t = null;

    public Voucher getObject() {
        return object;
    }

    public void setObject(Voucher object) {
        this.object = object;
    }

    public class Voucher {
        private String voucherNo;
        private LocalDateTime voucherDate;
        private BigDecimal totalCreditAmount;
        private BigDecimal totalDebitAmount;
        private VoucherType voucherType;
        private Set<Transaction> transactions;

        public BigDecimal getTotalCreditAmount() {
            return totalCreditAmount;
        }

        public void setTotalCreditAmount(BigDecimal totalCreditAmount) {
            this.totalCreditAmount = totalCreditAmount;
        }

        public BigDecimal getTotalDebitAmount() {
            return totalDebitAmount;
        }

        public void setTotalDebitAmount(BigDecimal totalDebitAmount) {
            this.totalDebitAmount = totalDebitAmount;
        }

        public Set<Transaction> getTransactions() {
            return transactions;
        }

        public void setTransactions(Set<Transaction> transactions) {
            this.transactions = transactions;
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

        public VoucherType getVoucherType() {
            return voucherType;
        }

        public void setVoucherType(VoucherType voucherType) {
            this.voucherType = voucherType;
        }

        public class VoucherType{

            public VoucherType() {
            }

            public VoucherType(Integer id, String name) {
                this.id = id;
                this.name = name;
            }

            public Integer id;
            public String name;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }



    public static class ChartAccount{
        public Long id;
        public String title;

        public ChartAccount() {
        }

        public ChartAccount(Long id, String title) {
            this.id = id;
            this.title = title;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Transaction {
        public ChartAccount chartAccount;
        public String transactionType;

        public Transaction() {
        }

        public Transaction(ChartAccount chartAccount, String transactionType) {
            this.chartAccount = chartAccount;
            this.transactionType = transactionType;
        }

        public ChartAccount getChartAccount() {
            return chartAccount;
        }

        public void setChartAccount(ChartAccount chartAccount) {
            this.chartAccount = chartAccount;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }
    }

    public ChartAccount getDebitAcc(){

       this.getObject().getTransactions().forEach(_t->{
           if(_t.transactionType.contains("dr")){
               t = _t;
           }
       });

       return t.getChartAccount();
    }

    public ChartAccount getCreditAcc(){
         this.getObject().getTransactions().forEach(_t->{
            if(_t.transactionType.contains("cr")){
                t = _t;
            }
        });

        return t.getChartAccount();
    }

}

