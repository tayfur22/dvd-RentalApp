package org.example;

import org.example.DTO.CustomerDTO;
import org.example.Entity.Customer;
import org.example.Entity.Film;
import org.example.Entity.Inventory;
import org.example.Service.CustomerServices;
import org.example.Repositories.DBCustomerRepoImpl;
import org.example.Service.InventoryServices;
import org.example.Utils.DBUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        // Creating a new customer service instance
//        CustomerServices customerServices = new CustomerServices();
//
//        // Creating a customer object
//        Customer newCustomer = new Customer(
//                0, 1, "Tayfur", "Tagizade", "tayfur@example.com", 123,
//                true, Date.valueOf("2025-01-24"), Timestamp.valueOf("2025-01-24 12:00:00"), 1
//        );
//
//        // Adding the new customer
//        customerServices.addCustomers(newCustomer);
//        System.out.println("Customer added!");
//
//        // Retrieving and printing all customers
//        List<Customer> customers = customerServices.getAllCustomers();
//        System.out.println("All Customers:");
//        customers.forEach(System.out::println);
//
//        // Updating a customer
////        newCustomer.setFirstName("John Updated");
////        customerServices.updateCustomers(newCustomer.getCustomerId(), newCustomer);
////        System.out.println("Customer updated!");
////
//        // Searching for customers by a keyword (in this case, "John")
////        List<Customer> searchedCustomers = customerServices.searchCustomers("John");
////        System.out.println("Searched Customers:");
////        searchedCustomers.forEach(System.out::println);
////
////        // Deleting a customer
////        customerServices.deleteCustomers(newCustomer.getCustomerId());
////        System.out.println("Customer deleted!");
////
////        // Retrieve and display all customers after deletion
////        List<Customer> updatedCustomers = customerServices.getAllCustomers();
////        System.out.println("All Customers after deletion:");
////        updatedCustomers.forEach(System.out::println);


//        InventoryServices inventoryServices = new InventoryServices();

//        // Test adding a new inventory
//        Inventory newInventory = new Inventory(1, 1, 1, new Timestamp(System.currentTimeMillis()));
//        inventoryServices.addInventory(newInventory);

//        // Test updating an inventory item
//        Inventory updatedInventory = new Inventory(2, 2,2, new Timestamp(System.currentTimeMillis()));
//        inventoryServices.updateInventory(1, updatedInventory);  // Assuming inventory ID 1 exists
////
////        // Test deleting an inventory item
//        inventoryServices.deleteInventory(1);  // Assuming inventory ID 1 exists
//
        // Test getting available films
//        List<Film> availableFilms = inventoryServices.getAvailableFilm();
//        if (!availableFilms.isEmpty()) {
//            System.out.println("Available Films:");
//            for (Film film : availableFilms) {
//                System.out.println("Film ID: " + film.getFilmId() + ", Title: " + film.getTitle() );
//            }
//        } else {
//            System.out.println("No available films found.");
//        }
//
//        // Test checking stock level
//        int stockLevel = inventoryServices.checkStockLevel(1, 1);  // Assuming film ID 1 and store ID 1 exist
//        System.out.println("Stock Level: " + stockLevel);
    }
}


