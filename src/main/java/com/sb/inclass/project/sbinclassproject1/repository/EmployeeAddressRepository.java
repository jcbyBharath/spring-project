package com.sb.inclass.project.sbinclassproject1.repository;

import com.sb.inclass.project.sbinclassproject1.entity.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {

    //@Query(value = "select * from address where city = 'test city2'", nativeQuery= true) named query
    @Query(value = "select a from EmployeeAddress a where a.city = :city")  //JPQL Query
    List<EmployeeAddress> findAddressByCity(@Param("city") String city);

    List<EmployeeAddress> findByCity(String city);


}
