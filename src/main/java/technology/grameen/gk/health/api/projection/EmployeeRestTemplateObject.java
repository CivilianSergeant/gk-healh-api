package technology.grameen.gk.health.api.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeRestTemplateObject {
    private List<Employee> Employees;

    private EmployeeSyncResponseObject Response;

    public EmployeeRestTemplateObject(){}

    public EmployeeRestTemplateObject(List<Employee> employees, EmployeeSyncResponseObject response) {
        Employees = employees;
        Response = response;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employee> Employees) {
        this.Employees = Employees;
    }

    public EmployeeSyncResponseObject getResponse() {
        return Response;
    }

    public void setResponse(EmployeeSyncResponseObject Response) {
        this.Response = Response;
    }
}
