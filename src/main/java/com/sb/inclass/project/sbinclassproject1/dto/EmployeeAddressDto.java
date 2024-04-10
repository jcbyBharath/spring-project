package com.sb.inclass.project.sbinclassproject1.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmployeeAddressDto {

    private String add1;

    private String add2;

    private String add3;

    private String state;

    private String city;

    private Integer zip;

    public EmployeeAddressDto setAdd1(String add1) {
        this.add1 = add1;
        return this;
    }

    public EmployeeAddressDto setAdd2(String add2) {
        this.add2 = add2;
        return this;
    }

    public EmployeeAddressDto setAdd3(String add3) {
        this.add3 = add3;
        return this;
    }

    public EmployeeAddressDto setState(String state) {
        this.state = state;
        return this;
    }

    public EmployeeAddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public EmployeeAddressDto setZip(Integer zip) {
        this.zip = zip;
        return this;
    }
}
