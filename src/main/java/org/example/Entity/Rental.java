package org.example.Entity;

import java.util.Date;

public class Rental {
    private int id;
    private int customerId;
    private int movieId;
    private Date rentalDate;
    private Date returnDate;


    public Rental(int id, int customerId, int movieId, Date rentalDate, Date returnDate) {
        this.id = id;
        this.customerId = customerId;
        this.movieId = movieId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}


