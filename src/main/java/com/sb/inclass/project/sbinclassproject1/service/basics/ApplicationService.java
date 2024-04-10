package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.dto.EmployeeDto;
import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import com.sb.inclass.project.sbinclassproject1.mapper.EmployeeMapper;
import com.sb.inclass.project.sbinclassproject1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;


    public void createEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.mapEmployeeDtoToEmployeeEntity(employeeDto);

        employeeRepository.save(employee);
    }


}
