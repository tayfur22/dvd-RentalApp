package org.example.Coverter;

import org.example.DTO.RentalDTO;
import org.example.Entity.Rental;

public class RentalConverter {

    public static RentalDTO toRentalDTO(Rental rental) {
        return new RentalDTO(
                rental.getRentalId(),
                rental.getRentalDate(),
                rental.getInventoryId(),
                rental.getReturnDate(),
                rental.getStaffId(),
                rental.getCustomerId(),
                rental.getLastUpdate()
        );
    }


    public static Rental toRental(RentalDTO rentalDTO) {
        return new Rental(
                rentalDTO.getRentalId(),
                rentalDTO.getRentalDate(),
                rentalDTO.getInventoryId(),
                rentalDTO.getReturnDate(),
                rentalDTO.getStaff_id(),
                rentalDTO.getCustomerId(),
                rentalDTO.getLastUpdate()

        );
    }
}
