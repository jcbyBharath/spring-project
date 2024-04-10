package com.sb.inclass.project.sbinclassproject1.service.basics;

import com.sb.inclass.project.sbinclassproject1.common.Addressdto;
import com.sb.inclass.project.sbinclassproject1.entity.EmployeeAddress;
import com.sb.inclass.project.sbinclassproject1.repository.EmployeeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private EmployeeAddressRepository addressRepository;

    public List<Addressdto> getAddress() {
        List<Addressdto> address = new ArrayList<>();

        Addressdto a1 = new Addressdto("add1", "add2", "add3", "city", "state", 23424234);
        address.add(a1);

        return address;
    }


    public EmployeeAddress addAddress(EmployeeAddress address) {
        return addressRepository.save(address);
    }

    public EmployeeAddress getAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    public List<EmployeeAddress> getAddressByCity(String city) {

        return addressRepository.findAddressByCity(city);
    }
}