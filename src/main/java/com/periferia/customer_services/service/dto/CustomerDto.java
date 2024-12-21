package com.periferia.customer_services.service.dto;

import lombok.Getter;

@Getter
public class CustomerDto {


    private final String fullName;
    private final int age;

    public CustomerDto( String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }


}
