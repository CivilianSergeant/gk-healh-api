package technology.grameen.gk.health.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("Select e,c,p,ps from Employee e LEFT JOIN FETCH e.center c LEFT JOIN FETCH e.patients p LEFT JOIN FETCH e.prescribes ps")
    public List<Employee> findAll();
}
