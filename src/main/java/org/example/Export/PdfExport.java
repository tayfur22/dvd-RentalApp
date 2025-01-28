package org.example.Export;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.example.Utils.DBUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PdfExport {
    public static void main(String[] args) {
        try (Connection connection = DBUtils.getConn()) {

            String query = "SELECT customer_id, first_name, last_name, email FROM customer";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            var contentStream = new org.apache.pdfbox.pdmodel.PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12); // Change font to Helvetica-Bold
            contentStream.newLineAtOffset(50, 750);

            // Column headers
            contentStream.showText("Customer ID      First Name      Last Name      Email");
            contentStream.newLineAtOffset(0, -15); // Move to the next line

            float lineHeight = 15f; // Adjust line height as needed
            float yPosition = 730; // Initial y position for data rows

            // Data rows
            while (rs.next()) {
                String row = String.format("%-15s%-20s%-20s%-30s",
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));

                contentStream.newLineAtOffset(0, -lineHeight); // Move to the next line
                contentStream.showText(row);
            }

            contentStream.endText();  // End text mode here

            // Close the content stream before saving
            contentStream.close();

            // Save the document
            File file = new File("C:\\Users\\Tayfur\\Desktop\\coders task\\customers.pdf");
            document.save(file);
            document.close();

            System.out.println("Data exported to PDF successfully!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
