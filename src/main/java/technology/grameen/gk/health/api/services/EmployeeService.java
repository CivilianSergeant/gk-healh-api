package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.responses.IResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAll();

    IResponse getEmployeeByApiEmployeeId(Long id);
}
