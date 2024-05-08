package com.zincat.assert_management.service.impl;

import com.zincat.assert_management.dto.request.AssertRequestDTO;
import com.zincat.assert_management.dto.response.AssertResponseDTO;
import com.zincat.assert_management.dto.response.EmployeeResponseDTO;
import com.zincat.assert_management.entity.Asserts;
import com.zincat.assert_management.entity.Employee;
import com.zincat.assert_management.repo.AssertsRepo;
import com.zincat.assert_management.repo.EmployeeRepo;
import com.zincat.assert_management.service.AssertService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssertServiceImpl implements AssertService {


    @Autowired
    private AssertsRepo assertsRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String saveAsserts(AssertRequestDTO assertRequestDTO) {
        Employee employee = employeeRepo.findEmployeeByName(assertRequestDTO.getEmployeeName());
        Asserts asserts = new Asserts(
                assertRequestDTO.getAssert_type(),
                assertRequestDTO.getCode(),
                assertRequestDTO.getName(),
                assertRequestDTO.getValue(),
                assertRequestDTO.getDesc(),
                assertRequestDTO.getLocation(),
                assertRequestDTO.getAssert_status(),
                employee
        );
        assertsRepo.save(asserts);
        return assertRequestDTO.getCode()+" is saved";
    }


    @Override
    public List<AssertResponseDTO> getAllAsserts() {
       List<Asserts> all_asserts = assertsRepo.getAsserts();
       List<AssertResponseDTO> asseerts = new ArrayList<>();

       for(Asserts a : all_asserts){
          Employee employee =  employeeRepo.findEmployeeById(a.getEmployee().getId());
          EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(employee.getName());
           AssertResponseDTO assertResponseDTO = new AssertResponseDTO(
                   a.getAssert_type(),
                   a.getCode(),
                   a.getName(),
                   a.getValue(),
                   a.getDesc(),
                   a.getLocation(),
                   a.isAssert_status(),
                   employeeResponseDTO
           );
           asseerts.add(assertResponseDTO);
       }
        return asseerts;
    }

    @Override
    public String updateAssert(int id, AssertRequestDTO assertRequestDTO) {
        Asserts searchedAssert = assertsRepo.findAssertsById(id);
        if (searchedAssert == null){
            return new EntityNotFoundException().getMessage();
        }else{
            Employee employee = employeeRepo.findEmployeeByName(assertRequestDTO.getEmployeeName());

            searchedAssert.setAssert_type(assertRequestDTO.getAssert_type());
            searchedAssert.setCode(assertRequestDTO.getCode());
            searchedAssert.setName(assertRequestDTO.getName());
            searchedAssert.setValue(assertRequestDTO.getValue());
            searchedAssert.setDesc(assertRequestDTO.getDesc());
            searchedAssert.setLocation(assertRequestDTO.getLocation());
            searchedAssert.setAssert_status(assertRequestDTO.getAssert_status());
            searchedAssert.setEmployee(employee);

            assertsRepo.save(searchedAssert);
        }
        return searchedAssert.getName()+" is updated";
    }

    @Override
    public String deleteAssertById(int id) {
        assertsRepo.deleteById(id);
        return "done";
    }

}
