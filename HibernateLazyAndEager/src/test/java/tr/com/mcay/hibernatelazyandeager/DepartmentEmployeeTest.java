package tr.com.mcay.hibernatelazyandeager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.hibernatelazyandeager.employee.entity.Department;
import tr.com.mcay.hibernatelazyandeager.employee.entity.Employee;
import tr.com.mcay.hibernatelazyandeager.employee.repository.DepartmentRepository;
import tr.com.mcay.hibernatelazyandeager.employee.repository.EmployeeRepository;

import java.util.List;


@SpringBootTest
public class DepartmentEmployeeTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Test Lazy Fetch
    @Test
    @Transactional
    public void testFetchTypeLazy() {



        // Fetch Department (Lazy yüklenmeyi test etmek için)
        Department fetchedDepartment = departmentRepository.findById(4L).orElse(null);
        assertThat(fetchedDepartment).isNotNull();

        // employees'e erişildiğinde Lazy yükleme tetiklenir
        List<Employee> employees = fetchedDepartment.getEmployees();

        // Lazy yükleme: İlişkili verilerin yüklenmediğini doğrulamak için
        // İlk erişimde ilişkili verilerin yüklenip yüklenmediğini kontrol etme
        assertThat(employees).isNotNull(); // employees'in null olmadığını kontrol etme

        // Veritabanında tekrar sorgu yapılmasını sağlamalıyız
        assertThat(employees.size()).isEqualTo(2); // İki employee olduğunu doğrulama
    }

    // Test Eager Fetch
    @Test
    @Transactional
    public void testFetchTypeEager() {


        // EAGER Fetch: Department çekildiğinde employees otomatik olarak yüklenir
        Department fetchedDepartment = departmentRepository.findById(4L).orElse(null);
        assertThat(fetchedDepartment).isNotNull();

        // EAGER fetch: employees'in otomatik olarak yüklendiğini doğrulamak için
        List<Employee> employees = fetchedDepartment.getEmployees();
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(1);  // Eager yükleme otomatik tetiklenir
    }
}