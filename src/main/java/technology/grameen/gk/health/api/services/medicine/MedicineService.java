package technology.grameen.gk.health.api.services.medicine;

import technology.grameen.gk.health.api.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    public Medicine addMedicine(Medicine medicine);
    public List<Medicine> getMedicines();
    Optional <Medicine> findById(Long id);
}
