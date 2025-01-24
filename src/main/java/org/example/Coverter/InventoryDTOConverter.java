package org.example.Coverter;

import org.example.DTO.InventoryDTO;
import org.example.Entity.Inventory;

public class InventoryDTOConverter {

    public static InventoryDTO toInventoryDTO(Inventory inventory){
        return new InventoryDTO(
                inventory.getInventoryId(),
                inventory.getFilmId(),
                inventory.getStoreId(),
                inventory.getLastUpdate()
        );
    }

    public static Inventory toInventory(InventoryDTO inventoryDTO){

        return new Inventory(
                inventoryDTO.getInventoryId(),
                inventoryDTO.getFilmId(),
                inventoryDTO.getStoreId(),
                inventoryDTO.getLastUpdate()
        );
    }
}
