package org.example.Repositories;

import org.example.Entity.Film;
import org.example.Entity.Inventory;
import org.example.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBInventoryRepoImpl implements InventoryRepository {

    @Override
    public void addInventory(Inventory inventory) {

        String addQuery = "Insert into inventory (film_id, store_id, last_update) Values (?,?,?)";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(addQuery)) {

            statement.setInt(1, inventory.getFilmId());
            statement.setInt(2, inventory.getStoreId());
            statement.setTimestamp(3, inventory.getLastUpdate());
            statement.executeUpdate();

            System.out.println("Inventory added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventory(int inventoryId, Inventory inventory) {

        String updateQuery = "UPDATE inventory SET film_id = ?, store_id = ?, last_update =?  Where inventory_id =?";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setInt(1, inventory.getFilmId());
            statement.setInt(2, inventory.getStoreId());
            statement.setTimestamp(3, inventory.getLastUpdate());
            statement.setInt(4, inventoryId);
            statement.executeUpdate();

            System.out.println("Inventory updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventory(int inventoryId) {

        String deleteQuery = "Delete from inventory Where inventory_id = ? ";

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setInt(1, inventoryId);
            statement.executeUpdate();

            System.out.println("Inventory deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Film> getAvailableFilm() {

        String displayQuery = """
                Select f.film_id, f.title, COUNT(i.inventory_id) as stock
                From film f
                Join inventory i on f.film_id = i.film_id
                GROUP BY f.film_id, f.title
                Having Count(i.inventory_id) > 0
                """;
        List<Film> films = new ArrayList<>();

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(displayQuery);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                int filmId = rs.getInt("film_id");
                String title = rs.getString("title");
                int stock = rs.getInt("stock");

                films.add(new Film(filmId, title, stock));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;

    }

    @Override
    public int checkStockLevel(int filmId, int storeId) {

        String stockQuery = """
                Select Count(*) as stock
                from inventory
                where film_id = ? and store_id = ?
                """;

        try (Connection connection = DBUtils.getConn();
             PreparedStatement statement = connection.prepareStatement(stockQuery)) {

            statement.setInt(1, filmId);
            statement.setInt(2, storeId);

            try (ResultSet rs = statement.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt("stock");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;

    }
}
