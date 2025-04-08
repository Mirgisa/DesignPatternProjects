package com.Accenture.mirgisa.service;

import com.Accenture.mirgisa.dto.CustomerDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public interface CustomerService {
    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
