package org.example.Repositories;

import org.example.Entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAll();

    void addCustomer(Customer customer);

    void updateCustomer(int customerId, Customer customer);

    void deleteCustomer(int customerId);

    List<Customer> searchCustomer(String keyword);

}
