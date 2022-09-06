package com.iftm.saleStore.services;

import com.iftm.saleStore.entities.Inventory;
import com.iftm.saleStore.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> findAll() {
        var inventoryList = inventoryRepository.findAll();
        return inventoryList;
    }

    public Inventory findById(String id) {
        var currentInventory = inventoryRepository.findById(id).stream().findFirst().orElse(null);
        return currentInventory;
    }

    public Inventory create(Inventory inventory) {
        var newInventory = inventoryRepository.save(inventory);
        return newInventory;
    }
}
