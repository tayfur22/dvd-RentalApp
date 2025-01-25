package org.example.Entity;

import java.sql.Timestamp;

public class Inventory {
    private int inventoryId;
    private int filmId;
    private int storeId;
    private Timestamp lastUpdate;

    public Inventory(int inventoryId, int filmId, int storeId, Timestamp lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", filmId=" + filmId +
                ", storeId='" + storeId + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}


