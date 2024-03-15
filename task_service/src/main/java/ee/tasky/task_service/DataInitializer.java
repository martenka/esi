package com.esi.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.esi.inventoryservice.inventory.model.InventoryItem;
import com.esi.inventoryservice.inventory.repository.InventoryRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            // InventoryItem inventoryItem1 = new InventoryItem();
            // inventoryItem1.setId("01");
            // inventoryItem1.setCode("p-109-09");
            // inventoryItem1.setQuantity(100);

            // InventoryItem inventoryItem2 = new InventoryItem();
            // inventoryItem2.setId("02");
            // inventoryItem2.setCode("p-109-10");
            // inventoryItem2.setQuantity(0);

            // inventoryRepository.save(inventoryItem1);
            // inventoryRepository.save(inventoryItem2);
        };
    }

}