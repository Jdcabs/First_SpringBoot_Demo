package com.example.test.controller;

import java.util.List;

import com.example.test.model.Customer;
import com.example.test.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService cService;

    // This Will Get the Details of all Customers.
    @GetMapping("/customers")
    public List<Customer> getCustomers(@RequestParam  Integer pageNumber, @RequestParam Integer pageSize) {
      
    return cService.getCustomer(pageNumber, pageSize);
    }

    // This Will Get the Customer Details by the ID Provided.
    @GetMapping("/customer")
    public Customer getCustomerById(@RequestParam("id") Long id) {

        return cService.getCustomerById(id);
    }

    // This Will Create new Customer.
    @PostMapping("/customers")
    public Customer createNewCustomers(@RequestBody Customer customer) {
        return cService.createCustomer(customer);
    }

    // This Will Delete Customer Details by the id provided.
    @DeleteMapping("/customer/delete")
    public void deleteCustomerById(@RequestParam("id") Long id) {
        cService.deleteCustomerById(id);
    }

    // This will Update the Customer Details by Id Provided.
    @PutMapping("/customer/update/{id}")
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        return cService.updateCustomerById(id, customer);
    }

}
