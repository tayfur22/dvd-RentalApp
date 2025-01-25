package org.example.Repositories;

import org.example.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DbRentalRepoImpl implements RentalRepository {

    @Override
    public boolean rentFilm(int customerId, int inventoryId, int staffId) {

        String rentQuery = "Insert into rental (rental_date,inventory_id,staff_id,customer_id,last_update) " +
                "Values (?,?,?,?,?)";

        String updateInventoryQuery = "Update inventory Set status = 'RENTED', last_update = ? " +
                "Where inventory_id = ?";

        try (Connection connection = DBUtils.getConn()) {

            try (PreparedStatement statement = connection.prepareStatement(rentQuery)) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                statement.setTimestamp(1, timestamp);
                statement.setInt(2, inventoryId);
                statement.setInt(3, staffId);
                statement.setInt(4, customerId);
                statement.setTimestamp(5, timestamp);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected == 0) {
                    return false;
                }
            }

            try (PreparedStatement updatestatement = connection.prepareStatement(updateInventoryQuery)) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                updatestatement.setTimestamp(1, timestamp);
                updatestatement.setInt(2, inventoryId);

                int rowsAffected = updatestatement.executeUpdate();
                if (rowsAffected == 0) {
                    return false;
                }
            }
            return true;


        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean returnFilm(int rentalId, Timestamp returnDate) {
        String returnQuery = "Update rental Set return_date = ?, last_update = ?" +
                "Where rental_id = ?";

        String updateInventoryQuery = "Update inventory Set status = 'AVAILABLE', last_update = ?" +
                "Where rental_id = ? ";

        try (Connection connection = DBUtils.getConn()){

            try (PreparedStatement rentstatement = connection.prepareStatement(returnQuery)){
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                rentstatement.setTimestamp(1,returnDate);
                rentstatement.setTimestamp(2,timestamp);
                rentstatement.setInt(3,rentalId);

                int rowAffected = rentstatement.executeUpdate();
                if (rowAffected == 0){
                    return false;
                }
            }

            try (PreparedStatement updateStatement = connection.prepareStatement(updateInventoryQuery)){
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                updateStatement.setTimestamp(1,timestamp);
                updateStatement.setInt(2,rentalId);

                int rowAffected = updateStatement.executeUpdate();
                if (rowAffected == 0){
                    return false;
                }

            }

            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
