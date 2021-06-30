package technology.grameen.gk.health.api.services.medicine;

import technology.grameen.gk.health.api.entity.MedicineGroup;

import java.util.List;

public interface MedicineGroupService {

    List<MedicineGroup> getList();

    MedicineGroup addMedicineGroup(MedicineGroup medicineGroup);
}
