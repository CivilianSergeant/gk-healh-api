package technology.grameen.gk.health.api.services.labtest;

import technology.grameen.gk.health.api.entity.LabTestDetail;

import java.util.List;
import java.util.Set;

public interface LabTestResultService {

    List<LabTestDetail> saveAll(Set<LabTestDetail> detail);
}
