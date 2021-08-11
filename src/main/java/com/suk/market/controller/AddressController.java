package com.suk.market.controller;

import com.suk.market.domain.Address;
import com.suk.market.dto.AddressDTO;
import com.suk.market.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PutMapping("/addresses/{id}")
    public Address updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable Long id) {
        return addressService.updateAddress(addressDTO, id);
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
