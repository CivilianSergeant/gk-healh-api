package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.repositories.EmployeeRepository;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;
import technology.grameen.gk.health.api.responses.SimpleResponse;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        HealthCenter center = employee.getCenter();
        if(center != null) {
            center.addEmployee(employee);
            employeeRepository.save(employee);
        }
        return employee;
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public IResponse getEmployeeByApiEmployeeId(Long id) {
        Integer count = employeeRepository.getCount(id);
        if(count>1){
            return new SimpleResponse(HttpStatus.OK.value(), "Sorry! There are several records found with same Api id");
        }
        return new EntityResponse<>(HttpStatus.OK.value(),employeeRepository.findByApiEmployeeId(id));
    }
}
