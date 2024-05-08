package com.zincat.assert_management.dto.request;

import com.zincat.assert_management.entity.Asserts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    private String name;
}
