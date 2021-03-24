package technology.grameen.gk.health.api.projection;

import java.time.LocalDateTime;

public class Employee {

    private Long TotalCount;
    private Long EmployeeId;
    private String EmployeeCode;
    private String EmployeeName;
    private String EmployeeNameBng;
    private String DesignationName;
    private String ContactNo;
    private String Email;
    private Long OfficeId;


    public Employee(){}

    public Employee(Long totalCount, Long employeeId, String employeeCode, String employeeName, String employeeNameBng, String designationName, String contactNo, String email, Long officeId) {
        TotalCount = totalCount;
        EmployeeId = employeeId;
        EmployeeCode = employeeCode;
        EmployeeName = employeeName;
        EmployeeNameBng = employeeNameBng;
        DesignationName = designationName;
        ContactNo = contactNo;
        Email = email;
        OfficeId = officeId;
    }

    public Long getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Long totalCount) {
        TotalCount = totalCount;
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

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeNameBng() {
        return EmployeeNameBng;
    }

    public void setEmployeeNameBng(String employeeNameBng) {
        EmployeeNameBng = employeeNameBng;
    }

    public String getDesignationName() {
        return DesignationName;
    }

    public void setDesignationName(String designationName) {
        DesignationName = designationName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getOfficeId() {
        return OfficeId;
    }

    public void setOfficeId(Long officeId) {
        OfficeId = officeId;
    }
}
