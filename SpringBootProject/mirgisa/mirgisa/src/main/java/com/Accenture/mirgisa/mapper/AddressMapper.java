package com.Accenture.mirgisa.mapper;

import com.Accenture.mirgisa.dto.AddressDTO;
import com.Accenture.mirgisa.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDto(Address address);
    Address toEntity(AddressDTO dto);
}
