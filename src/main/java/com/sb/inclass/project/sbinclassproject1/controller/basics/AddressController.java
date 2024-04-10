package com.sb.inclass.project.sbinclassproject1.controller.basics;

import com.sb.inclass.project.sbinclassproject1.entity.EmployeeAddress;
import com.sb.inclass.project.sbinclassproject1.service.basics.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public EmployeeAddress addAddress(@RequestBody EmployeeAddress address) {

        return addressService.addAddress(address);
    }

    /**
     *
     * query param: addressId - 2
     *
     * find the record..
     *
     */
    @GetMapping("/getAddressById")
    public EmployeeAddress getAddressById(@RequestParam Long id) {
     return addressService.getAddressById(id);
    }


    @GetMapping("/getAddressByCity")
    public List<EmployeeAddress> getAddressByCity(@RequestParam String city) {
        return addressService.getAddressByCity(city);
    }
}
