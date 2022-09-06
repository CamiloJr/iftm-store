package com.iftm.saleStore.message;

import com.iftm.saleStore.entities.Inventory;
import com.iftm.saleStore.services.InventoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class InventoryReceiveMessage {
    @Autowired
    private InventoryService inventoryService;

    @RabbitListener(queues = {"${saleStore.rabbitmq.queue}"})
    public void receive(@Payload Inventory inventory) {
        inventoryService.create(inventory);
    }
}
