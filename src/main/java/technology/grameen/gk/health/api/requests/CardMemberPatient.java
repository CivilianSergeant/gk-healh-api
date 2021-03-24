package technology.grameen.gk.health.api.requests;

import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.entity.PatientDetail;

public class CardMemberPatient {

    private String guardianName;
    private String motherName;
    private String gender;
    private String maritalStatus;
    private String mobileNumber;
    private String age;

    private HealthCenter center;

    private PatientDetail detail;

    private Employee createdBy;
}
