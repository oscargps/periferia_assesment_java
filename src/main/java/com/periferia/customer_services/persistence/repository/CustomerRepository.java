package com.periferia.customer_services.persistence.repository;

import com.periferia.customer_services.persistence.entity.CustomerEntity;
import com.periferia.customer_services.service.dto.CustomerAgeAverageDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {
    List<CustomerEntity> findAllByOrderByFullNameAsc();

    @Query(value =
            "SELECT COUNT(*) as customerCount, " +
                    "AVG(YEAR(CURRENT_DATE) - YEAR(date_of_birth)) as averageAge " +
                    "FROM customers",
            nativeQuery = true)
    CustomerAgeAverageDto getCustomerAgeAverage();
}
