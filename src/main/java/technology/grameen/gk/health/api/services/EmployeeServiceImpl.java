package technology.grameen.gk.health.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.entity.HealthCenter;
import technology.grameen.gk.health.api.projection.EmployeeItem;
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
    public Page<EmployeeItem> getAll(Pageable pageable) {
        return employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public Page<EmployeeItem> getAll(Long centerId,
                                     String employeeCode,
                                     String fullName,
                                     String contactNo,
                                     String email,
                                     Pageable pageable) {

        if(centerId != null){
            return employeeRepository.findAllByCenterId(centerId,pageable);
        }
        if(!employeeCode.isEmpty() && !fullName.isEmpty() && !contactNo.isEmpty() && !email.isEmpty()){

        }else if(!employeeCode.isEmpty()) {
            return employeeRepository.findAllByEmployeeCodeContaining(employeeCode,pageable);
        }else if(!fullName.isEmpty()){
            return employeeRepository.findAllByFullNameContainingIgnoreCase(fullName,pageable);
        }else if(!contactNo.isEmpty()){
            return employeeRepository.findAllByContactNumberContaining(contactNo,pageable);
        }else if(!email.isEmpty()){
            return employeeRepository.findAllByEmailContainingIgnoreCase(email,pageable);
        }

        return employeeRepository.findAllEmployee(pageable);
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
