package com.sb.inclass.project.sbinclassproject1.mapper;

import com.sb.inclass.project.sbinclassproject1.dto.EmployeeAddressDto;
import com.sb.inclass.project.sbinclassproject1.dto.EmployeeDto;
import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import com.sb.inclass.project.sbinclassproject1.entity.EmployeeAddress;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    //backward
    public Employee mapEmployeeDtoToEmployeeEntity(EmployeeDto employeeDto) {

        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDob(employeeDto.getDob());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        employee.setEin(employeeDto.getEin());

        EmployeeAddress employeeAddress = mapEmployeeAddressDtoToEmployeeAddress(employeeDto.getEmployeeAddressDto());
        employee.setEmployeeAddress(employeeAddress);

        return employee;
    }

    //forward -- builder
    public EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {

        EmployeeDto employeeDto = new EmployeeDto()
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setDob(employee.getDob())
                .setEmail(employee.getEmail())
                .setSalary(employee.getSalary())
                .setEin(employee.getEin());

        return employeeDto;
    }

    public EmployeeAddress mapEmployeeAddressDtoToEmployeeAddress(EmployeeAddressDto employeeAddressDto) {

        EmployeeAddress employeeAddress = new EmployeeAddress();
        employeeAddress.setAddress1(employeeAddressDto.getAdd1());
        employeeAddress.setAddress2(employeeAddressDto.getAdd2());
        employeeAddress.setAddress3(employeeAddressDto.getAdd3());
        employeeAddress.setState(employeeAddressDto.getState());
        employeeAddress.setCity(employeeAddressDto.getCity());
        employeeAddress.setZip(employeeAddressDto.getZip());

        return employeeAddress;
    }

    public EmployeeAddressDto mapEmployeeAddressToEmployeeAddressDto(EmployeeAddress employeeAddress) {

        EmployeeAddressDto employeeAddressDto = new EmployeeAddressDto()
        .setAdd1(employeeAddress.getAddress1())
        .setAdd2(employeeAddress.getAddress2())
        .setAdd3(employeeAddress.getAddress3())
        .setState(employeeAddress.getState())
        .setCity(employeeAddress.getCity())
        .setZip(employeeAddress.getZip());

        return employeeAddressDto;
    }
}
