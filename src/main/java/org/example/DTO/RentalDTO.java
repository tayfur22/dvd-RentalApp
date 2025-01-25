package org.example.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class RentalDTO {
        private int rentalId;
        private Timestamp rentalDate;
        private int inventoryId;
        private Timestamp returnDate;
        private int staff_id;
        private int customerId;
        private Timestamp lastUpdate;

        public RentalDTO(int rentalId, Timestamp rentalDate, int inventoryId, Timestamp returnDate, int staff_id, int customerId, Timestamp lastUpdate) {
            this.rentalId = rentalId;
            this.rentalDate = rentalDate;
            this.inventoryId = inventoryId;
            this.returnDate = returnDate;
            this.staff_id = staff_id;
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

        public int getStaff_id() {
            return staff_id;
        }

        public void setStaff_id(int staff_id) {
            this.staff_id = staff_id;
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


