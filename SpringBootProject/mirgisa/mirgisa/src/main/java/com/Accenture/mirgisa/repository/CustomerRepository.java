package com.Accenture.mirgisa.repository;

import com.Accenture.mirgisa.DTO.CustomerDTO;
import com.Accenture.mirgisa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
