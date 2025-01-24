package org.example.Repositories;

import org.example.Entity.Customer;
import org.example.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCustomerRepoImpl implements CustomerRepository {

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        String query = "Select customer_id, first_name, last_name, email, address_id," +
                " activebool, create_date, last_update, active, store_id FROM customer";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("address_id"),
                        resultSet.getBoolean("activebool"),
                        resultSet.getDate("create_date"),
                        resultSet.getTimestamp("last_update"),
                        resultSet.getInt("active")

                );
                customers.add(customer);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        String insertQuery = "Insert into customer (first_name, last_name, email, address_id," +
                "activebool, create_date, last_update, active, store_id) Values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {


            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAddressId());
            statement.setBoolean(5, customer.isActivebool());
            statement.setDate(6, customer.getCreateDate());
            statement.setTimestamp(7, customer.getLastUpdate());
            statement.setInt(8, customer.getActive());
            statement.setInt(9, customer.getStoreId());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {

        String updateQuery = "UPDATE customer SET first_name = ?, last_name = ?, email = ?, address_id = ?," +
                "activebool = ?, create_date = ?, last_update = ?, active = ?, store_id =? WHERE customer_id = ?";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getAddressId());
            statement.setBoolean(5, customer.isActivebool());
            statement.setDate(6, customer.getCreateDate());
            statement.setTimestamp(7, customer.getLastUpdate());
            statement.setInt(8, customer.getActive());
            statement.setInt(9, customer.getStoreId());
            statement.setInt(10, customerId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int customerId) {

        String deleteQuery = "Delete from customer WHERE customer_id = ? ";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setInt(1, customerId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchCustomer(String keyword) {

        List<Customer> customers = new ArrayList<>();
        String searchQuery = "Select customer_id, first_name, last_name, email, address_id," +
                " activebool, create_date, last_update, active, store_id FROM customer " +
                "Where first_name = ? OR last_name = ? or email = ?";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(searchQuery)) {
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            statement.setString(3, keyword);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getInt("customer_id"),
                        resultSet.getInt("store_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getInt("address_id"),
                        resultSet.getBoolean("activebool"),
                        resultSet.getDate("create_date"),
                        resultSet.getTimestamp("last_update"),
                        resultSet.getInt("active")

                );
                customers.add(customer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
