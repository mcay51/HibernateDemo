package tr.com.mcay.hibernatelazyandeager.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatelazyandeager.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
