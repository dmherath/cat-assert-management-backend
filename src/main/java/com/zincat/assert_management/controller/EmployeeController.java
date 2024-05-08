package com.zincat.assert_management.controller;

import com.zincat.assert_management.dto.request.EmployeeDTO;
import com.zincat.assert_management.entity.Employee;
import com.zincat.assert_management.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO.getName());
        employeeRepo.save(employee);
        return employeeDTO.getName()+" is saved";
    }
}
