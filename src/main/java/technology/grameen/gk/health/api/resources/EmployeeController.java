package technology.grameen.gk.health.api.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.services.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping("")
    public ResponseEntity<List<Employee>> list(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee req){
        return new ResponseEntity<>(employeeService.addEmployee(req),HttpStatus.OK);
    }
}
