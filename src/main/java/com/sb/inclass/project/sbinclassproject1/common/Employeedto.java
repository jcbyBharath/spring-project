package com.sb.inclass.project.sbinclassproject1.common;

import java.time.LocalDate;

public class Employeedto {

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private Integer employeeId;

    private Integer ein;


    public Employeedto() {

    }
    public Employeedto(String firstName, String lastName, LocalDate dob, Integer employeeId, Integer ein) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.employeeId = employeeId;
        this.ein = ein;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEin() {
        return ein;
    }

    public void setEin(Integer ein) {
        this.ein = ein;
    }
}
