package technology.grameen.gk.health.api.services.labtest;

import technology.grameen.gk.health.api.entity.LabTest;
import technology.grameen.gk.health.api.projection.LabTestListItem;

import java.util.List;

public interface LabTestService {

    LabTest saveLabTest(LabTest labTest);

    List<LabTestListItem> getLabTestReports();
}
