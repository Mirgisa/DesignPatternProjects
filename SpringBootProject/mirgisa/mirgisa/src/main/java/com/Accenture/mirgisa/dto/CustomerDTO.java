package com.Accenture.mirgisa.dto;

import lombok.Data;

import java.util.Objects;
@Data
public class CustomerDTO {
    private Long customer_id;

    private String first_name;

    private String last_name;

    private String email;

    private AddressDTO address;

}
