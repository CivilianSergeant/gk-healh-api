package technology.grameen.gk.health.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gk.health.api.entity.Employee;
import technology.grameen.gk.health.api.projection.EmployeeItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT e from Employee e JOIN FETCH e.center c",
    countQuery = "SELECT e from Employee e JOIN FETCH e.center c")
    Page<EmployeeItem> findAllEmployee(Pageable pageable);

    @Query("Select e from Employee e WHERE  e.apiEmployeeId=:id")
    Optional<Employee> findByApiEmployeeId(@Param("id") Long id);

    @Query(value = "SELECT COUNT(e.id) FROM Employee e WHERE e.apiEmployeeId=:id")
    Integer getCount(@Param("id") Long id);
}
