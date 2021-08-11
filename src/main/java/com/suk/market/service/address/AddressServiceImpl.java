package com.suk.market.service.address;

import com.suk.market.domain.Address;
import com.suk.market.dto.AddressDTO;
import com.suk.market.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddress(AddressDTO addressDTO, Long id) {
        Address address = addressRepository.findById(id).get();
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZipcode(addressDTO.getZipCode());
        address.setAddressType(addressDTO.getAddressType());
        return addressRepository.save(address);
    }


}

