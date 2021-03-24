package technology.grameen.gk.health.api.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class EmployeeRestTemplateObject {
    private List<Employee> employees;

    private EmployeeSyncResponseObject response;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeSyncResponseObject getResponse() {
        return response;
    }

    public void setResponse(EmployeeSyncResponseObject response) {
        this.response = response;
    }
}
