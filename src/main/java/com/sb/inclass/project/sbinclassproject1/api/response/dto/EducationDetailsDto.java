package com.sb.inclass.project.sbinclassproject1.api.response.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EducationDetailsDto {

    private EducationLevel educationLevel;

    private LocalDate fromDate;

    private LocalDate toDate;

    private EmployeeInfoDto employeeInfoDto;

    private UniversityDto universityDto;

    public EducationDetailsDto setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public EducationDetailsDto setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public EducationDetailsDto setToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public EducationDetailsDto setEmployeeInfoDto(EmployeeInfoDto employeeInfoDto) {
        this.employeeInfoDto = employeeInfoDto;
        return this;
    }

    public EducationDetailsDto setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
        return this;
    }
}
