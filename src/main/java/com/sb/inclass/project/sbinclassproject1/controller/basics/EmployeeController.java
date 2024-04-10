package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.common.Employeedto;
import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import com.sb.inclass.project.sbinclassproject1.service.basics.AddressService;
import com.sb.inclass.project.sbinclassproject1.service.basics.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/getEmployees")
    public List<Employeedto> getEmployees( String name) {
        return  employeeService.getEmployees();
    }

    @PostMapping("/addEmployee")
    public List<Employeedto> addEmployee(@RequestBody Employeedto e) {

       return employeeService.addEmployee(e);
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getEmployeeByFirstName")
    public List<Employee> getEmployeeByFirstName(@RequestParam String name) {

        return employeeService.findEmployeeByName(name);
    }

    @GetMapping("/getEmployeeByFirstNameWithLimit")
    public List<Employee> getEmployeeByFirstNameWithLimit(@RequestParam String name) {
        return employeeService.getLimitedUsers(name);
    }

    @GetMapping("/getEmployeeByFirstNameAndLastName")
    public List<Employee> getEmployeeByFirstNameAndLastName(@RequestParam String fName,
                                                            @RequestParam String lName) {
        return employeeService.findByFirstNameAndLastname(fName, lName);
    }

    @GetMapping("/updateEmployee")
    public void updateEmployee(@RequestParam String fName,
                               @RequestParam String lName) {
         employeeService.updateEmployee(fName, lName);
    }

    @DeleteMapping("/deleteEmployeeByFirstName")
    public void deleteEmployeeByFirstName(@RequestParam String fName) {
        employeeService.deleteEmployeeByFirstName(fName);
    }
}
