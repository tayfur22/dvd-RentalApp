package org.example.Repositories;

import org.example.Entity.Rental;

import java.sql.Timestamp;

public interface RentalRepository {

    boolean rentFilm(int customerId,int inventoryId, int staffId);
    boolean returnFilm(int rentalId, Timestamp returnDate);
}
