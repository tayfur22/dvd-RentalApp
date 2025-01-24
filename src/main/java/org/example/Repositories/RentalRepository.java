package org.example.Repositories;

import org.example.Entity.Rental;

public interface RentalRepository {

    boolean rentFilm(Rental rental);
    boolean returnFilm(int rentalId, Rental rental);
    boolean updateInventory(int inventory_id);
}
