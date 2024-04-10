package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.dto.EmployeeDto;
import com.sb.inclass.project.sbinclassproject1.service.basics.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/createEmployee")
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        applicationService.createEmployee(employeeDto);
    }

    @PostMapping("/createEmployeeWithAddress")
    public void createEmployeeWithAddress(@RequestBody EmployeeDto employeeDto) {
        applicationService.createEmployee(employeeDto);
    }

}
