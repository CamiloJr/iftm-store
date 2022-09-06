package com.iftm.saleStore.repositories;

import com.iftm.saleStore.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
