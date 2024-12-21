package com.periferia.customer_services.web.controller;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import com.periferia.customer_services.service.CustomerService;
import com.periferia.customer_services.service.dto.CreateCustomerDto;
import com.periferia.customer_services.service.dto.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/new")
    public ResponseEntity<CustomerEntity> createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {
        CustomerEntity createdCustomer = customerService.createCustomer(createCustomerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return ResponseEntity.ok(this.customerService.getAllCustomersSorted());
    }

    @GetMapping("/allByAge")
    public List<CustomerDto> getCustomersSortedByAge() {
        return customerService.getAllCustomersSortedByAge();
    }
}
