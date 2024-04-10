package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.entity.Company;
import com.sb.inclass.project.sbinclassproject1.entity.CompanyAddress;
import com.sb.inclass.project.sbinclassproject1.repository.CompanyAddressRepository;
import com.sb.inclass.project.sbinclassproject1.repository.CompanyRepository;
import com.sb.inclass.project.sbinclassproject1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationsService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanyAddressRepository companyAddressRepository;


  public void  insertCompanyData(Company company) {
      Company c = companyRepository.save(company);

      for(CompanyAddress companyAddress : company.getCompanyAddress()) {
          companyAddress.setCompany(c);
          companyAddressRepository.save(companyAddress);
      }
  }

  public void insertCompanyAddress(CompanyAddress companyAddress) {
    companyAddressRepository.save(companyAddress);
  }

  public List<Company> getAllCompanies() {
      return companyRepository.findAll();
  }

    public Company updateCompanyDetails(Long companyId, Company company) {

     Company c =  companyRepository.getReferenceById(companyId);

     if(c != null) {
         company.setName(company.getName());
         company.setTicker(company.getTicker());
        return  companyRepository.save(c);
     }
     return c;
    }
}
