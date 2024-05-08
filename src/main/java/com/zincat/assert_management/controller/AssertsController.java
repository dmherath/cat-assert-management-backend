package com.zincat.assert_management.controller;

import com.zincat.assert_management.dto.request.AssertRequestDTO;
import com.zincat.assert_management.dto.response.AssertResponseDTO;
import com.zincat.assert_management.service.AssertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/asserts")
public class AssertsController {

    @Autowired
    private AssertService assertService;

    @PostMapping("/save")
    public ResponseEntity<String> saveAssert(@RequestBody AssertRequestDTO assertRequestDTO){
        String saved = assertService.saveAsserts(assertRequestDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-asserts")
    public ResponseEntity<List<AssertResponseDTO>> getAllAsserts(){
       List<AssertResponseDTO> assertResponse = assertService.getAllAsserts();
       return new ResponseEntity<>(assertResponse,HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAsserts(@PathVariable int id, @RequestBody AssertRequestDTO assertRequestDTO){
        assertService.updateAssert(id,assertRequestDTO);
        return new ResponseEntity<>(assertRequestDTO.getName(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAssert(@PathVariable int id){
        String deletedAssert = assertService.deleteAssertById(id);
        return new ResponseEntity<>(deletedAssert+" : is deleted from the database", HttpStatus.OK);
    }
}
