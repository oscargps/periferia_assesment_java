package com.periferia.customer_services.service;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import com.periferia.customer_services.persistence.repository.CustomerRepository;
import com.periferia.customer_services.service.dto.CreateCustomerDto;
import com.periferia.customer_services.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerEntity createCustomer(CreateCustomerDto createCustomerDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setFullName(createCustomerDto.getFullName());
        customer.setIdentityDocument(createCustomerDto.getIdentityDocument());
        customer.setEmail(createCustomerDto.getEmail());
        customer.setDateOfBirth(createCustomerDto.getDateOfBirth());
        customer.setTimeZone(createCustomerDto.getTimeZone());
        return customerRepository.save(customer);
    }

    public List<CustomerEntity> getAllCustomersSorted() {
        return customerRepository.findAllByOrderByFullNameAsc();
    }


    public List<CustomerDto> getAllCustomersSortedByAge() {
        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> new CustomerDto(
                        customer.getFullName(),
                        calculateAge(customer.getDateOfBirth())
                ))
                .sorted(Comparator.comparingInt(CustomerDto::getAge))
                .collect(Collectors.toList());
    }

    private Integer calculateAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
