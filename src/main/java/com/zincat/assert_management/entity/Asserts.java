package com.zincat.assert_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asserts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assert_id")
    private int id;

    @Column(name="assert_type")
    private String assert_type;

    @Column(name="assert_code", nullable = false)
    private String code;

    @Column(name="assert_name", nullable = false)
    private String name;

    @Column(name = "assert_value")
    private double value;

    @Column(name = "assert_description")
    private String desc;

    @Column(name = "assert_location")
    private String location;

    @Column(name="is_inactive")
    private boolean assert_status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Asserts(String assert_type, String code, String name, double value, String desc, String location, boolean assert_status, Employee employee) {
        this.assert_type = assert_type;
        this.code = code;
        this.name = name;
        this.value = value;
        this.desc = desc;
        this.location = location;
        this.assert_status = assert_status;
        this.employee = employee;
    }
}
