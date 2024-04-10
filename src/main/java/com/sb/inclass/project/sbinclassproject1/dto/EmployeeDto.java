package com.sb.inclass.project.sbinclassproject1.dto;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private Integer ein;

    private String email;

    private Double salary;

    private EmployeeAddressDto employeeAddressDto;


    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeDto setDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public EmployeeDto setEin(Integer ein) {
        this.ein = ein;
        return this;
    }

    public EmployeeDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeDto setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeDto setEmployeeAddressDto(EmployeeAddressDto employeeAddressDto) {
        this.employeeAddressDto = employeeAddressDto;
        return this;
    }
}
