package com.sb.inclass.project.sbinclassproject1.controller;

import com.sb.inclass.project.sbinclassproject1.common.Employeedto;
import com.sb.inclass.project.sbinclassproject1.controller.basics.EmployeeController;
import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import com.sb.inclass.project.sbinclassproject1.service.basics.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


//@RunWith(MockitoJUnitRunner.class)

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController sut; //system under test..

    @Mock
    private EmployeeService employeeService;

    @Test
    public void getEmployees_test_1() {
        List<Employeedto> employeedtos = getEmployeedtos();
        doReturn(employeedtos).when(employeeService).getEmployees();

        List<Employeedto> result = sut.getEmployees("test");

        verify(employeeService, times(1)).getEmployees();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void addEmployee_test() {
        doReturn(new ArrayList<Employeedto>()).when(employeeService).addEmployee(any(Employeedto.class));

        Employeedto employeedto = new Employeedto();
        List<Employeedto> actual = sut.addEmployee(employeedto);

        verify(employeeService, times(1)).addEmployee(any(Employeedto.class));
        assertNotNull(actual);
        assertEquals(0, actual.size());
    }


    @Test
    public void getEmployeeByFirstName() {
        doReturn(new ArrayList<Employeedto>()).when(employeeService).findEmployeeByName(anyString());
        List<Employee> list = sut.getEmployeeByFirstName("TestUser");

        verify(employeeService, times(1)).findEmployeeByName(anyString());
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void createEmployee() {

        Employee employee = new Employee();
        doReturn(employee).when(employeeService).saveEmployee(any(Employee.class));

        Employee employee1 = sut.createEmployee(employee);

        verify(employeeService, times(1)).saveEmployee(any(Employee.class));
        assertNotNull(employee1);
    }


    @Test
    public void getEmployee_test() {
        Employee employee = new Employee();
        employee.setFirstName("TestFirstName");
        employee.setLastName("TestLastName");

     doReturn(employee).when(employeeService).getEmployeeById(anyLong());

     Employee actual = sut.getEmployee(10L);

     verify(employeeService, times(1)).getEmployeeById(anyLong());

     assertNotNull(actual);
     assertEquals("TestFirstName", actual.getFirstName());
     assertEquals("TestLastName", actual.getLastName());
    }



    @Test
    public void deleteEmployeeTest() {
        doNothing().when(employeeService).deleteEmployee(anyLong());

        sut.deleteEmployee(10L);


        verify(employeeService, times(1)).deleteEmployee(anyLong());
    }



    @Test
    public void updateEmployee_test() {

        doNothing().when(employeeService).updateEmployee(anyString(), anyString());

        sut.updateEmployee("testFirstName", "testLastName");

        verify(employeeService, times(1)).updateEmployee(anyString(), anyString());
    }

    @Test
    public void getEmployeeByFirstNameAndLastName_test() {
        doReturn(new ArrayList<Employee>()).when(employeeService).findByFirstNameAndLastname(anyString(), anyString());

       List<Employee> actual= sut.getEmployeeByFirstNameAndLastName("testFirstName", "testLastName");

        verify(employeeService, times(1)).findByFirstNameAndLastname(anyString(), anyString());
        assertEquals(0, actual.size());
    }

    @Test
    public void getEmployeeByFirstNameWithLimit_test() {
        doReturn(new ArrayList<Employee>()).when(employeeService).getLimitedUsers(anyString());

        List<Employee> employees = sut.getEmployeeByFirstNameWithLimit("testFirstName");

        verify(employeeService, times(1)).getLimitedUsers(anyString());
        assertNotNull(employees);
        assertEquals(0, employees.size());
    }

    @Test
    public void deleteEmployeeByFirstName_test() {
        ArgumentCaptor<String> fNameArgumentCaptor = ArgumentCaptor.forClass(String.class);
        doNothing().when(employeeService).deleteEmployeeByFirstName(fNameArgumentCaptor.capture());

        sut.deleteEmployeeByFirstName("TestUser");

        verify(employeeService, times(1)).deleteEmployeeByFirstName(anyString());
        assertEquals("TestUser", fNameArgumentCaptor.getValue());
    }


    private static List<Employeedto> getEmployeedtos() {
        List<Employeedto> employeedtos = new ArrayList<>();
        Employeedto employeedto = new Employeedto();
        employeedto.setEmployeeId(12334);
        employeedto.setDob(LocalDate.now());
        employeedto.setFirstName("Test User FirstName");
        employeedto.setFirstName("Test User LastName");

        employeedtos.add(employeedto);
        return employeedtos;
    }



}
