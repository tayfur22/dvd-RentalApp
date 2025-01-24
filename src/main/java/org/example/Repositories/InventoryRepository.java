package org.example.Repositories;

import org.example.Entity.Film;
import org.example.Entity.Inventory;

import java.util.List;

public interface InventoryRepository {

    void addInventory(Inventory inventory);
    void updateInventory(int inventoryId,Inventory inventory);
    void deleteInventory(int inventoryId);
    List<Film> getAvailableFilm();
    int checkStockLevel(int filmId, int storeId);
}
