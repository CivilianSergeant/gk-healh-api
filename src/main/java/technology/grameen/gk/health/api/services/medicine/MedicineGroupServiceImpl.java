package technology.grameen.gk.health.api.services.medicine;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.MedicineGroup;
import technology.grameen.gk.health.api.repositories.MedicineBrandRepository;
import technology.grameen.gk.health.api.repositories.MedicineGroupRepository;

import java.util.List;

@Service
public class MedicineGroupServiceImpl implements MedicineGroupService{

    private MedicineGroupRepository medicineGroupRepository;

    MedicineGroupServiceImpl (MedicineGroupRepository medicineGroupRepository){
        this.medicineGroupRepository = medicineGroupRepository;
    }

    @Override
    public List<MedicineGroup> getList() {
        return this.medicineGroupRepository.findAll();
    }

    @Override
    @Transactional
    public MedicineGroup addMedicineGroup(MedicineGroup medicineGroup) {
        return medicineGroupRepository.save(medicineGroup);
    }
}
