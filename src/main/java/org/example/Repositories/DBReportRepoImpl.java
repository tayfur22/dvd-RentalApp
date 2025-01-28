package org.example.Repositories;

import org.example.Entity.Film;
import org.example.Utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReportRepoImpl implements ReportRepository {

    @Override
    public List<String> getTop10RentedFilms() {

        List<String> topMovies = new ArrayList<>();

        String query = """
                select title as Film_Title, count(*) as Rental_Count
                from film f\s
                join inventory i on f.film_id = i.film_id\s
                join rental r on r.inventory_id = i.inventory_id\s
                group by title\s
                order by Rental_Count desc\s
                limit 10;
                """;


        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String title = resultSet.getString("Film_Title");
                int rentalCount = resultSet.getInt("Rental_Count");

                topMovies.add("Title: " + title + " | Rental counts: " + rentalCount);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topMovies;

    }

    @Override
    public List<String> getMonthlyRentalsAndRevenue() {

        List<String> monthlyReports = new ArrayList<>();

        String query = """
                SELECT
                    EXTRACT(MONTH FROM rental_date) AS month,
                    EXTRACT(YEAR FROM rental_date) AS year,
                    COUNT(*) AS rental_count,
                    SUM(payment.amount) AS total_revenue
                FROM
                    rental
                JOIN
                    payment ON rental.rental_id = payment.rental_id
                GROUP BY
                    year, month
                ORDER BY
                    year, month
                
                """;
        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int month = resultSet.getInt("month");
                int year = resultSet.getInt("year");
                double rentalCount = resultSet.getDouble("rental_count");
                double totalRevenue = resultSet.getDouble("total_revenue");

                monthlyReports.add("Month: " + month + " | Year: " + year +
                        " | Rental Count: " + rentalCount + " | Total Revenue: " + totalRevenue);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monthlyReports;
    }

    @Override
    public List<String> getCustomerActivityReport() {

        List<String> customerReports = new ArrayList<>();

        String query = """
                Select c.customer_id,c.first_name,c.last_name,f.title AS rented_movie,
                r.rental_date, p.amount AS payment_amount
                from customer c  
                JOIN rental r ON c.customer_id = r.customer_id  
                JOIN inventory i ON r.inventory_id = i.inventory_id  
                JOIN film f ON i.film_id = f.film_id  
                JOIN payment p ON r.rental_id = p.rental_id 
                ORDER BY r.rental_date DESC 
                """;

        try (Connection connection = DBUtils.getConn();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                int customerId = resultSet.getInt("customer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String rentedMovie = resultSet.getString("rented_movie");
                Date rentalDate = resultSet.getDate("rental_date");
                double paymentAmount = resultSet.getDouble("payment_amount");

                customerReports.add("Customer ID: " + customerId + " | Name: " + firstName + " " + lastName +
                        " | Rented Movie: " + rentedMovie + " | Rental Date: " + rentalDate +
                        " | Payment: $" + paymentAmount);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return customerReports;
    }
}
