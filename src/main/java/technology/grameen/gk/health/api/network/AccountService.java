package technology.grameen.gk.health.api.network;

import org.springframework.http.ResponseEntity;
import technology.grameen.gk.health.api.exceptions.CustomException;
import technology.grameen.gk.health.api.requests.VoucherSendRequest;
import technology.grameen.gk.health.api.responses.VoucherSendResponse;

public interface AccountService {

    Object sendVoucher(VoucherSendRequest req) throws Exception;
}
