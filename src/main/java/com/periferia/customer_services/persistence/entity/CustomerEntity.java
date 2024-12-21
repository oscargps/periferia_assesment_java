package com.periferia.customer_services.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "identity_document", nullable = false, length = 50, unique = true)
    private String identityDocument;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private java.time.LocalDate dateOfBirth;

    @Column(name = "time_zone", nullable = false, length = 50)
    private String timeZone;
}
