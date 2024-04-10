package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.entity.Company;
import com.sb.inclass.project.sbinclassproject1.service.basics.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company) {
       return companyService.addCompany(company);
    }

    @GetMapping("/getCompanyById/{id}")
    public Company getCompanyById(@PathVariable Long id) {

        return companyService.getCompanyById(id);
    }

    @GetMapping("/getCompanyByName")
    public List<Company> getCompanyByName(@RequestParam String name) {
        return companyService.getCompanyByName(name);
    }



}
