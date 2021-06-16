package technology.grameen.gk.health.api.services.voucher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Voucher;
import technology.grameen.gk.health.api.repositories.VoucherRepository;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    private VoucherRepository voucherRepository;

    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    @Override
    @Transactional
    public Voucher addVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    @Transactional
    public Voucher updateVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Page<Voucher> getVouchers(Pageable pageable) {
        return voucherRepository.findAll(pageable);
    }
}
