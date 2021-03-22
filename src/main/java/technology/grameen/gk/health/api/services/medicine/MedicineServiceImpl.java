package technology.grameen.gk.health.api.services.medicine;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Medicine;
import technology.grameen.gk.health.api.repositories.MedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService{

    MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineRepository repo){
        this.medicineRepository = repo;
    }

    @Override
    @Transactional
    public Medicine addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return medicine;
    }

    @Override
    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    @Override
    public Optional <Medicine> findById(Long id) {
        return medicineRepository.findById(id);
    }
}
