package com.periferia.customer_services.web.controller;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import com.periferia.customer_services.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAll() {
        return ResponseEntity.ok(this.customerService.getAllCustomersSorted());
    }

}
