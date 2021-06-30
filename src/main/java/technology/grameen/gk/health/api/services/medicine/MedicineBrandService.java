package technology.grameen.gk.health.api.services.medicine;

import technology.grameen.gk.health.api.entity.MedicineBrand;
import technology.grameen.gk.health.api.entity.MedicineGroup;

import java.util.List;

public interface MedicineBrandService {

    List<MedicineBrand> getList();

    MedicineBrand addMedicineBrand(MedicineBrand medicineBrand);
}
