package org.example.Export;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Utils.DBUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ExcelExport {
    public static void main(String[] args) {

        try (Connection connection = DBUtils.getConn()){

            String query = "SELECT customer_id, first_name, last_name, email FROM customer";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Customers");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Customer ID");
            headerRow.createCell(1).setCellValue("First Name");
            headerRow.createCell(2).setCellValue("Last Name");
            headerRow.createCell(3).setCellValue("Email");

            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getInt("customer_id"));
                row.createCell(1).setCellValue(rs.getString("first_name"));
                row.createCell(2).setCellValue(rs.getString("last_name"));
                row.createCell(3).setCellValue(rs.getString("email"));
            }

            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Tayfur\\Desktop\\coders task\\customers.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Data exported to Excel successfully!");
            }

            workbook.close();

        }catch (SQLException e) {

            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();

        }catch (IOException e){

            System.out.println("File error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
