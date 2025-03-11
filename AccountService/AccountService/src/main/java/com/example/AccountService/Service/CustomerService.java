package com.example.AccountService.Service;

import com.example.AccountService.Model.Customer;
import com.example.AccountService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findByCustomerNumber(Long customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }


}
