package technology.grameen.gk.health.api.services.voucher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.Voucher;

import java.util.List;

public interface VoucherService {
    Voucher addVoucher(Voucher voucher);
    Voucher updateVoucher(Voucher voucher);

    Page<Voucher> getVouchers(Pageable pageable);
}
