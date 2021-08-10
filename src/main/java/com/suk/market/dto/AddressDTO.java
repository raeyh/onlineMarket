package com.suk.market.dto;

import com.suk.market.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String state;

    private String city;

    private String zipCode;

    private String country;

    private AddressType addressType;
}
