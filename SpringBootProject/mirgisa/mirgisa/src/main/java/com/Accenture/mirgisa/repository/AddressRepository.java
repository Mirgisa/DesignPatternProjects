package com.Accenture.mirgisa.repository;

import com.Accenture.mirgisa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
