package com.rotini.sales.repository;


import com.rotini.sales.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/api/product")
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
