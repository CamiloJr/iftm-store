package com.iftm.saleStore.controllers;

import com.iftm.saleStore.entities.Inventory;
import com.iftm.saleStore.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}")
    public Inventory findById(@PathVariable String id) {
        return inventoryService.findById(id);
    }

    @GetMapping
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return inventoryService.create(inventory);
    }
}
