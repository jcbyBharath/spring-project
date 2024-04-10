package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.common.Employeedto;
import com.sb.inclass.project.sbinclassproject1.entity.Company;
import com.sb.inclass.project.sbinclassproject1.entity.CompanyAddress;
import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import com.sb.inclass.project.sbinclassproject1.entity.EmployeeAddress;
import com.sb.inclass.project.sbinclassproject1.repository.CompanyRepository;
import com.sb.inclass.project.sbinclassproject1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employeedto> getEmployees() {

        List<Employeedto> employees = new ArrayList<>();
        Employeedto e1 = new Employeedto("fName1", "lName1", LocalDate.now(),  123456, 456789);
        Employeedto e2 = new Employeedto("fName2", "lName2", LocalDate.now(),  123456, 456789);
        Employeedto e3 = new Employeedto("fName3", "lName3", LocalDate.now(),  123456, 456789);
        Employeedto e4 = new Employeedto("fName4", "lName4", LocalDate.now(),  123456, 456789);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        return employees;
    }

    public List<Employeedto> addEmployee(Employeedto e) {
        List<Employeedto> employees = new ArrayList<>();
        employees.add(e);

        return employees;

    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findEmployeeByName(String firstName) {
       return employeeRepository.findByName(firstName);
    }

    public List<Employee> getLimitedUsers(String firstName) {
        List<Employee> employees= employeeRepository.findTop3ByFirstName(firstName);
        return employees;
    }

    public List<Employee> findByFirstNameAndLastname(String firstName, String lastName) {
        List<Employee> employees = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
        return employees;
    }

    @Transactional
    public void updateEmployee(String firstName, String lastName) {
        employeeRepository.updateEmployeeLastNameByFirstName(firstName, lastName);
    }

    @Transactional
    public void deleteEmployeeByFirstName(String firstName) {
        employeeRepository.deleteEmployeeByFirstName(firstName);
    }
}
