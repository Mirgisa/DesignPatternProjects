package com.Accenture.mirgisa.service;

import com.Accenture.mirgisa.dto.CustomerDTO;
import com.Accenture.mirgisa.exception.CustomerNotFoundException;
import com.Accenture.mirgisa.mapper.CustomerMapper;
import com.Accenture.mirgisa.model.Customer;
import com.Accenture.mirgisa.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Component

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        return customers.stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer saved = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(saved);
    }

    /**
     * @param id
     * @param customerDTO
     * @return
     */
    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        // 🔁 Use mapper to copy values from DTO to entity
        customerMapper.updateCustomerFromDTO(customerDTO, existingCustomer);

        Customer updated = customerRepository.save(existingCustomer);
        return customerMapper.customerToCustomerDTO(updated);
    }

    /**
     * @param id
     */
    @Override
    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        customerRepository.delete(existingCustomer);

    }

}
