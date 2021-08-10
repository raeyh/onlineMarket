package com.suk.market.service;

import com.suk.market.domain.Address;
import com.suk.market.dto.AddressDTO;

public interface AddressService {

    Address getAddressById(Long id);

    void deleteAddress(Long id);

    Address updateAddress(AddressDTO addressDTO, Long id);
}
