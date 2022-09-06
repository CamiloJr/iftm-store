package com.iftm.saleStore.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "inventory")
public class Inventory {

    @Id
    private String id;
    private String name;
    private Integer inventory;
}
