package com.rotini.sales.service;


import com.rotini.sales.domain.Customer;
import com.rotini.sales.domain.CustomerDepositDTO;
import com.rotini.sales.domain.CustomerWithdrawDTO;
import com.rotini.sales.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public boolean deleteById(Integer id) {
        return false;
    }


    public Customer deposit(Integer id, CustomerDepositDTO customerDepositDTO) {
        Customer customer = getById(id);
        if(!customer.getCode().equals(customerDepositDTO.getCode())) {
            throw new RuntimeException("Customer code mismatch");
        }

        customer.setBalance(customer.getBalance() + customerDepositDTO.getAmount());
        customerRepository.save(customer);
        return customer;
    }

    public Customer withdraw(Integer id, CustomerWithdrawDTO customerWithdrawDTO) {
        Customer customer = getById(id);
        if (!customer.getCode().equals(customerWithdrawDTO.getCode())){
            throw new RuntimeException("Customer code mismatch");
        }
        if(customer.getBalance() < customerWithdrawDTO.getAmount()) {
            throw new RuntimeException("Customer balance mismatch");
        }
        customer.setBalance(customer.getBalance() - customerWithdrawDTO.getAmount());
        customerRepository.save(customer);
        return customer;
    }
}
