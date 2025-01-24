package org.example.Service;

import org.example.Entity.Film;
import org.example.Entity.Inventory;
import org.example.Repositories.DBInventoryRepoImpl;

import java.util.List;

public class InventoryServices {

    DBInventoryRepoImpl dbInventoryRepo = new DBInventoryRepoImpl();

    public void addInventory(Inventory inventory){
        dbInventoryRepo.addInventory(inventory);
    }

    public void updateInventory(int inventoryId,Inventory inventory){
        dbInventoryRepo.updateInventory(inventoryId,inventory);
    }

    public void deleteInventory(int inventoryId){
        dbInventoryRepo.deleteInventory(inventoryId);
    }

    public List<Film> getAvailableFilm(){
        return dbInventoryRepo.getAvailableFilm();
    }

    public int checkStockLevel(int filmId, int storeId){

        return dbInventoryRepo.checkStockLevel(filmId,storeId);
    }
}
