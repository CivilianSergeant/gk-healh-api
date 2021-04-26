package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.projection.EmployeeItem;
import technology.grameen.gk.health.api.responses.IResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Page<EmployeeItem> getAll(Pageable pageable);

    IResponse getEmployeeByApiEmployeeId(Long id);
}
