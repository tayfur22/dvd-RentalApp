package org.example.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    static String URL = "jdbc:postgresql://localhost:5432/dvdrental";
    static String USER = "postgres";
    static String PASSWORD = "tayfur2005";

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConn()) {
            System.out.println("Verilənlər bazasına uğurla qoşuldu!");
        } catch (SQLException e) {
            System.out.println("Bağlantıda xəta baş verdi: " + e.getMessage());
        }


    }
}
