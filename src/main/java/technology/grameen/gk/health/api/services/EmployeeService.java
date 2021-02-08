package technology.grameen.gk.health.api.services;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public List<Employee> getAll();
}
