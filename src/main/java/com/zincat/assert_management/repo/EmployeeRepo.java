package com.zincat.assert_management.repo;
import com.zincat.assert_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByName(String employeeName);

    Employee findEmployeeById(int id);
}
