package com.example.test.service;

import com.example.test.model.Customer;

import java.util.List;

public interface CustomerService {
    // This Will Return All the Customers Detail.
    List<Customer> getCustomer(Integer pageNumber, Integer pageSizeInteger);

    // This Will Create new Customer.
    Customer createCustomer(Customer customer);
    
    // This Will get the Customer details by Id provided.
    Customer getCustomerById(Long id);
    
    // This Will Delete the Customer details by id provided.
    void deleteCustomerById(Long id);

    // This Will Update the Customer details by id provided
    Customer updateCustomerById(Long id, Customer customer);
}
