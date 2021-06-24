package technology.grameen.gk.health.api.network;

import org.springframework.http.ResponseEntity;
import technology.grameen.gk.health.api.exceptions.CustomException;
import technology.grameen.gk.health.api.requests.VoucherSendRequest;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.VoucherSendResponse;
import technology.grameen.gk.health.api.services.invoice.PatientInvoiceService;

import java.util.Collection;

public interface AccountService {

    Object sendVoucher(VoucherSendRequest req) throws Exception;

    EntityCollectionResponse getAlias(String moduleName, String token);

    void setPatientInvoiceService(PatientInvoiceService patientInvoiceService);
}
