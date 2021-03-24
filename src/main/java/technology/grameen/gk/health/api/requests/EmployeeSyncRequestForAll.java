package technology.grameen.gk.health.api.requests;

public class EmployeeSyncRequestForAll {

    private Long OfficeId;
    private String OfficeCode;
    private Long EmployeeId;
    private String EmployeeCode;
    private Integer RoleId;
    private Integer PageNumber;
    private Integer PageSize;

    public EmployeeSyncRequestForAll() {
        OfficeId = Long.valueOf(0);
        OfficeCode = "";
        EmployeeId = Long.valueOf(0);
        EmployeeCode = "";
        RoleId = 0;
        PageNumber =1;
        PageSize=20;
    }
}
