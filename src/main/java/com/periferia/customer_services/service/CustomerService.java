package com.periferia.customer_services.service;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import com.periferia.customer_services.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomersSorted() {
        return customerRepository.findAllByOrderByFullNameAsc();
    }

}
