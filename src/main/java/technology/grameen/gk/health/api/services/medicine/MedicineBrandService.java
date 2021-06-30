package technology.grameen.gk.health.api.services.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.MedicineBrand;
import technology.grameen.gk.health.api.entity.MedicineGroup;

import java.util.List;
import java.util.Optional;

public interface MedicineBrandService {

    List<MedicineBrand> getList();

    Page<MedicineBrand> getBrands(String name, Pageable pageable);

    MedicineBrand addMedicineBrand(MedicineBrand medicineBrand);

    Optional<MedicineBrand> getBrandById(Long id);
}
