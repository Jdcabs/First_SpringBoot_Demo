package com.example.test.service;

import java.util.List;
import java.util.Optional;

import com.example.test.globalexceptionhandling.CustomerNotCreatedException;
import com.example.test.globalexceptionhandling.CustomerNotFoundException;
import com.example.test.model.Customer;
import com.example.test.repository.CustomerJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerJPARepository customerJPARepository;

    // This will Return All the Details of the Customers.
    @Override
    public List<Customer> getCustomer(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return customerJPARepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerJPARepository.deleteById(id);
    }
    
    // This Will get the Customer Details by id provided.
    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerJPARepository.findById(id);

        if(customer.isPresent()){
            return customer.get();
        }else
            throw new CustomerNotFoundException();
    }

    // This Will Create New Customers.
    @Override
    public Customer createCustomer(Customer customer) {
    return customerJPARepository.save(customer);
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        
        Optional<Customer> optional = customerJPARepository.findById(id);

        if (optional.isPresent()) {
            return  customerJPARepository.save(customer);
        } else {
            throw new CustomerNotFoundException();
        }
    }
}
