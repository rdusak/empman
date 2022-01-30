package rdusak.demo.empman.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rdusak.demo.empman.model.Employee;

@Repository
@EnableAutoConfiguration
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
