package com.sb.inclass.project.sbinclassproject1.repository;

import com.sb.inclass.project.sbinclassproject1.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,  Long> {

    @Query(value="Select c from  Company c where c.name = :name")
    List<Company> getCompanyByName(@Param("name") String name);
}
