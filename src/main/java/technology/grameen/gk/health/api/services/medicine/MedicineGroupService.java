package technology.grameen.gk.health.api.services.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gk.health.api.entity.MedicineBrand;
import technology.grameen.gk.health.api.entity.MedicineGroup;

import java.util.List;
import java.util.Optional;

public interface MedicineGroupService {

    List<MedicineGroup> getList();

    Page<MedicineGroup> getGroups(String name, Pageable pageable);

    MedicineGroup addMedicineGroup(MedicineGroup medicineGroup);

    Optional<MedicineGroup> getBrandById(Long id);
}
