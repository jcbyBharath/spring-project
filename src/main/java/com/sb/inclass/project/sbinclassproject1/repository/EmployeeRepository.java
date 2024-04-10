package com.sb.inclass.project.sbinclassproject1.repository;

import com.sb.inclass.project.sbinclassproject1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName = :fName and e.lastName = :lName")
    List<Employee> findByName(@Param("fName") String firstName);

    //positional parameters..
    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 and e.lastName= ?2")
    List<Employee> findMyFirstName(String firstName, String lastName);

    @Query(value = "SELECT * FROM employee WHERE first_name =:fName limit 3", nativeQuery = true)
    List<Employee> findByFirstName(@Param("fName") String firstName);

    @Query(value = "SELECT * FROM employee WHERE first_name ='Bharath ' limit 1", nativeQuery = true)
    List<Employee> findByFirstNameTest(String firstName);


    List<Employee> findTop3ByFirstName(String firstName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    @Modifying
    @Query("update Employee e set e.lastName=:lName where e.firstName=:fName")
    void updateEmployeeLastNameByFirstName(@Param("fName") String firstName, @Param("lName") String lastName);

    void deleteEmployeeByFirstName(String firstName);
}
