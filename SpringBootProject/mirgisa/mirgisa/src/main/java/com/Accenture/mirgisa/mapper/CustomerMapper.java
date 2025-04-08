package com.Accenture.mirgisa.mapper;

import com.Accenture.mirgisa.dto.CustomerDTO;
import com.Accenture.mirgisa.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CustomerMapper {

   // CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);


    void updateCustomerFromDTO(CustomerDTO dto, @MappingTarget Customer entity);


}
