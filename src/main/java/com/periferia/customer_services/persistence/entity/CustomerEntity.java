package com.periferia.customer_services.persistence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Full name is required")
    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @NotBlank(message = "Identity document is required")
    @Column(name = "identity_document", nullable = false, length = 50, unique = true)
    private String identityDocument;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @NotNull(message = "Date of birth is required")
    @Column(name = "date_of_birth", nullable = false)
    private java.time.LocalDate dateOfBirth;

    @NotNull(message = "TimeZone is required")
    @Column(name = "time_zone", nullable = false, length = 50)
    private String timeZone;
}
