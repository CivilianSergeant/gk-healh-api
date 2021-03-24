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

    public Long getOfficeId() {
        return OfficeId;
    }

    public void setOfficeId(Long officeId) {
        OfficeId = officeId;
    }

    public String getOfficeCode() {
        return OfficeCode;
    }

    public void setOfficeCode(String officeCode) {
        OfficeCode = officeCode;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    public Integer getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        PageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }
}
