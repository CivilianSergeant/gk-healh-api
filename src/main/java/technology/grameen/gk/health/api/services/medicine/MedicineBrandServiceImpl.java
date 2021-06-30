package technology.grameen.gk.health.api.services.medicine;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.MedicineBrand;
import technology.grameen.gk.health.api.repositories.MedicineBrandRepository;

import java.util.List;

@Service
public class MedicineBrandServiceImpl implements MedicineBrandService{

    private MedicineBrandRepository medicineBrandRepository;

    MedicineBrandServiceImpl(MedicineBrandRepository medicineBrandRepository){
        this.medicineBrandRepository = medicineBrandRepository;
    }

    @Override
    public List<MedicineBrand> getList() {
        return this.medicineBrandRepository.findAll();
    }

    @Override
    @Transactional
    public MedicineBrand addMedicineBrand(MedicineBrand medicineBrand) {
        return medicineBrandRepository.save(medicineBrand);
    }
}
