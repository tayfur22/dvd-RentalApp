package org.example.Repositories;

import org.example.Entity.Payment;
import org.example.Utils.DBUtils;

import java.sql.*;

public class DbPaymentRepoImpl implements PaymentRepository {

    @Override
    public boolean addPayment(Payment payment) {

        String InsertQuery = "Insert into payment(customer_id,staff_id,rental_id,amount,payment_date) " +
                "Values (?,?,?,?,?)";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(InsertQuery)) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            statement.setInt(1, payment.getCustomerId());
            statement.setInt(2, payment.getStaffId());
            statement.setInt(3, payment.getRentalId());
            statement.setDouble(4, payment.getAmount());
            statement.setTimestamp(5, timestamp);

            int rowInserted = statement.executeUpdate();

            return rowInserted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }

    @Override
    public double getTotalPaymentsByDateRange(Timestamp startDate, Timestamp endDate) {

        String totalPaymentsQuery = "Select SUM(amount) as total_amount from payment" +
                " WHERE payment_date BETWEEN ? and ? ";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(totalPaymentsQuery)) {

            statement.setTimestamp(1, startDate);
            statement.setTimestamp(2, endDate);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {
                    return rs.getDouble("total_amount");
                }

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getTotalPaymentsByCustomer(int customerId) {
        String totalPaymentsQuery = """
                Select Sum(amount) as total_amount
                From payment
                Where customer_id = ?
                """;

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(totalPaymentsQuery)) {

            statement.setInt(1, customerId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    return resultSet.getDouble("total_amount");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


