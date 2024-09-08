package tr.com.mcay.hibernatelazyandeager.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.mcay.hibernatelazyandeager.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
