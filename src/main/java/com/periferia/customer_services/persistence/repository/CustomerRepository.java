package com.periferia.customer_services.persistence.repository;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {
    List<CustomerEntity> findAllByOrderByFullNameAsc();

}
