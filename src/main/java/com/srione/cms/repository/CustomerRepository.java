package com.srione.cms.repository;

import com.srione.cms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustomerFirstName(String custFName);

    List<Customer> findByCustomerLastName(String custLName);

    List<Customer> findByCustomerEmail(String custEmail);
}
