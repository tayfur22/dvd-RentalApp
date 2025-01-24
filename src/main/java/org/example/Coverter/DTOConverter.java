package org.example.Coverter;

import org.example.DTO.CustomerDTO;
import org.example.Entity.Customer;

import java.sql.SQLException;

public class DTOConverter {

    public static CustomerDTO toCustomerDTO(Customer customer) throws SQLException{
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddressId(customer.getAddressId());
        customerDTO.setActivebool(customer.isActivebool());
        customerDTO.setCreateDate(customer.getCreateDate());
        customerDTO.setLastUpdate(customer.getLastUpdate());
        customerDTO.setActive(customer.getActive());

        return customerDTO;
    }


}
