package com.Accenture.mirgisa.mapper;

import com.Accenture.mirgisa.DTO.CustomerDTO;
import com.Accenture.mirgisa.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);


    void updateCustomerFromDTO(CustomerDTO dto, @MappingTarget Customer entity);


}
