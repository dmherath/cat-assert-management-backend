package com.zincat.assert_management.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssertResponseDTO {

    private String assert_type;
    private String code;
    private String name;
    private double value;
    private String desc;
    private String location;
    private boolean status;
    private EmployeeResponseDTO employeeName;
}
