package technology.grameen.gk.health.api.projection;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ServiceRecord {

        public LocalDate getDate();
        public String getInvoiceNumber();
        public String getName();
        public String getAddress();
        public BigDecimal getReceivableAmount();
        public BigDecimal getPaid();
        Long getHealthCenterId();
        Long getPatientId();
        Long getInvoiceId();

}
