package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.entity.Company;
import com.sb.inclass.project.sbinclassproject1.entity.CompanyAddress;
import com.sb.inclass.project.sbinclassproject1.service.basics.AssociationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/associations")
@RestController
public class AssociationsController {


    @Autowired
    private AssociationsService associationsService;

    @PostMapping("/addCompany")
    public void insertCompanyData(@RequestBody Company company) {
        associationsService.insertCompanyData(company);
    }


    @PostMapping("/addCompanyAddress")
    public void insertCompanyAddress(@RequestBody CompanyAddress companyAddress) {
        associationsService.insertCompanyAddress(companyAddress);
    }
    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies() {
       return associationsService.getAllCompanies();
    }

    @GetMapping("/updateCompanyDetails")
    public Company updateCompanyDetails(@RequestParam Long companyId,
                                              @RequestBody Company company) {
        return associationsService.updateCompanyDetails(companyId, company);
    }



    @PostMapping("/employee")
    public void insertEmployeeData() {

    }


    @PostMapping("/employee-skillset")
    public void insertEmployeeWithSkillsetData() {

    }
}
