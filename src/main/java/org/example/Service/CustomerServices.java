package org.example.Service;

import org.example.Entity.Customer;
import org.example.Repositories.DBCustomerRepoImpl;

import java.util.List;

public class CustomerServices {

    private DBCustomerRepoImpl customerRepo = new DBCustomerRepoImpl();

    public List<Customer> getAllCustomers(){
       return customerRepo.getAll();
    }

    public void addCustomers(Customer customer){
         customerRepo.addCustomer(customer);
    }

    public void updateCustomers(int customerId,Customer customer){
        customerRepo.updateCustomer(customerId,customer);
    }

    public void deleteCustomers(int customerId){
        customerRepo.deleteCustomer(customerId);
    }

    public List<Customer> searchCustomers(String keyword){
       return customerRepo.searchCustomer(keyword);
    }

}
