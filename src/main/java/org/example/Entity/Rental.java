package org.example.Entity;

import java.sql.Timestamp;
import java.util.Date;

public class Rental {
    private int rentalId;
    private Timestamp rentalDate;
    private int inventoryId;
    private Timestamp returnDate;
    private int staffId;
    private int customerId;
    private Timestamp lastUpdate;

    public Rental(int rentalId, Timestamp rentalDate, int inventoryId, Timestamp returnDate, int staffId, int customerId, Timestamp lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.returnDate = returnDate;
        this.staffId = staffId;
        this.customerId = customerId;
        this.lastUpdate = lastUpdate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staff_id) {
        this.staffId = staffId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}


