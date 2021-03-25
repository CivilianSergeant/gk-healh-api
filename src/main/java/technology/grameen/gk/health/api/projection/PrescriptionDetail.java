package technology.grameen.gk.health.api.projection;

import technology.grameen.gk.health.api.entity.RecommendedMedicine;
import technology.grameen.gk.health.api.entity.RecommendedTest;

import java.util.List;

public interface PrescriptionDetail {

    interface Center {
        Long getId();
        String getName();
        String getCenterCode();
    }

    interface Doctor{
        Long getId();
        String getFullName();
    }

    Center getCenter();
    Doctor getDoctor();
    String getpNumber();
    List<RecommendedMedicine> getRecommendedMedicines();
    List<RecommendedTest> getRecommendedTests();
}
