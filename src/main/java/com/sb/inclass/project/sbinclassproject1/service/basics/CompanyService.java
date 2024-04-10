package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.entity.Company;
import com.sb.inclass.project.sbinclassproject1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company) {
       return  companyRepository.save(company);
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).get();
    }

    public List<Company> getCompanyByName(String name) {

        return companyRepository.getCompanyByName(name);
    }
}
