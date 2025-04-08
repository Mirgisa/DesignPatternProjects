package com.Accenture.mirgisa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AddressDTO {


    private Long address_id;

    private String address;

    private String district;

    private String location;


}
