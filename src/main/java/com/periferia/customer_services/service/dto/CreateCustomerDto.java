package com.periferia.customer_services.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class CreateCustomerDto {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Identity document is required")
    private String identityDocument;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "TimeZone is required")
    private String timeZone;
}
