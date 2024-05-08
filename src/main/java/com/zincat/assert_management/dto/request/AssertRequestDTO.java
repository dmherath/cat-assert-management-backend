package com.zincat.assert_management.dto.request;

import com.zincat.assert_management.dto.response.EmployeeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssertRequestDTO {

    private String assert_type;
    private String code;
    private String name;
    private double value;
    private String desc;
    private String location;
    private boolean assert_status;
    private String employeeName;

    public boolean getAssert_status() {
        return assert_status;
    }
}
